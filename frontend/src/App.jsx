import { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import './App.css';

function App() {
    const API_BASE_URL = 'http://localhost:8080';
    const [prompt, setPrompt] = useState('');
    const [messages, setMessages] = useState([]);
    const [currentConversationId, setCurrentConversationId] = useState(null);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState('');
    const messagesEndRef = useRef(null);
    const [allConversations, setAllConversations] = useState([]);
    const [showHistory, setShowHistory] = useState(false);

    const scrollToBottom = () => {
        messagesEndRef.current?.scrollIntoView({ behavior: "smooth" });
    };

    useEffect(() => {
        scrollToBottom();
    }, [messages]);

    useEffect(() => {
        fetchAllConversations();
    }, []);

    const fetchAllConversations = async () => {
        try {
            setIsLoading(true);
            const response = await axios.get(`${API_BASE_URL}/gemini-ai-wrapper/v1/conversation`);
            if (response.data && response.data.conversations) {
                setAllConversations(response.data.conversations);
            }
        } catch (err) {
            console.error("Error loading conversations:", err);
            setError('Failed to load conversation history.');
        } finally {
            setIsLoading(false);
        }
    };

    const handleSendPrompt = async (e) => {
        e.preventDefault();
        if (!prompt.trim() || isLoading) return;

        const userMessage = { sender: 'user', text: prompt };
        setMessages((prevMessages) => [...prevMessages, userMessage]);
        setError('');
        setIsLoading(true);
        const currentPrompt = prompt;
        setPrompt('');

        try {
            const requestBody = {
                prompt: currentPrompt,
                conversationId: currentConversationId,
            };

            const response = await axios.post(`${API_BASE_URL}/gemini-ai-wrapper/v1/chat`, requestBody);

            const aiMessage = { sender: 'ai', text: response.data.responseText };
            setMessages((prevMessages) => [...prevMessages, aiMessage]);

            if (response.data.conversationId) {
                setCurrentConversationId(response.data.conversationId);
            } else if (!currentConversationId && response.data.conversations && response.data.conversations.length > 0) {
                const latestConversation = response.data.conversations[response.data.conversations.length - 1];
                if(latestConversation && latestConversation.parentConversation)
                    setCurrentConversationId(latestConversation.parentConversation.id);
            }

            await fetchAllConversations();

        } catch (err) {
            console.error("Error sending prompt:", err);
            let errorMessage = 'Failed to get response from AI.';
            if (err.response && err.response.data) {
                errorMessage = typeof err.response.data === 'string' ? err.response.data : JSON.stringify(err.response.data);
            } else if (err.message) {
                errorMessage = err.message;
            }
            setError(errorMessage);
        } finally {
            setIsLoading(false);
        }
    };

    const loadConversation = async (id) => {
        if (!id) return;
        setIsLoading(true);
        setError('');
        setMessages([]);
        setCurrentConversationId(id);
        try {
            const response = await axios.get(`${API_BASE_URL}/gemini-ai-wrapper/v1/conversation/${id}`);
            if (response.data && response.data.conversations) {
                const formattedMessages = response.data.conversations.flatMap(conv => [
                    { sender: 'user', text: conv.prompt },
                    { sender: 'ai', text: conv.response }
                ]);
                setMessages(formattedMessages);
            } else {
                setMessages([]);
            }
            setShowHistory(false);
        } catch (err) {
            console.error("Error loading conversation:", err);
            setError(`Failed to load conversation ${id}.`);
            setCurrentConversationId(null);
        } finally {
            setIsLoading(false);
        }
    };

    const startNewChat = () => {
        setMessages([]);
        setCurrentConversationId(null);
        setError('');
        setShowHistory(false);
    };

    const formatDate = (timestamp) => {
        if (!timestamp) return "No date";
        const date = new Date(timestamp);
        return date.toLocaleString();
    };

    const getConversationSummary = (conversation) => {
        if (!conversation || !conversation.prompt) return "Empty conversation";
        return conversation.prompt.length > 25
            ? conversation.prompt.substring(0, 25) + "..."
            : conversation.prompt;
    };

    return (
        <div className="chat-container">
            <h1>Gemini AI</h1>

            {showHistory && (
                <div className="history-panel">
                    <h2>Conversation History</h2>
                    {allConversations.length === 0 ? (
                        <p className="no-history">No previous conversations found.</p>
                    ) : (
                        <div className="conversation-list">
                            {allConversations.map((conv, index) => (
                                <div
                                    key={conv.id || index}
                                    className="conversation-item"
                                    onClick={() => loadConversation(conv.id)}
                                >
                                    <div className="conversation-summary">
                                        {getConversationSummary(conv)}
                                    </div>
                                    <div className="conversation-date">
                                        {formatDate(conv.timestamp || conv.createdAt)}
                                    </div>
                                </div>
                            ))}
                        </div>
                    )}
                    <button
                        className="close-history-btn"
                        onClick={() => setShowHistory(false)}
                    >
                        Close
                    </button>
                </div>
            )}

            <div className="messages-area">
                {messages.length === 0 && !isLoading && (
                    <div className="empty-state">
                        <p>Start a new conversation or select from history</p>
                    </div>
                )}
                {messages.map((msg, index) => (
                    <div key={index} className={`message ${msg.sender}`}>
                        <span className="sender-label">{msg.sender === 'user' ? 'You' : 'Gemini'}</span>
                        <p>{msg.text}</p>
                    </div>
                ))}
                <div ref={messagesEndRef} />
            </div>

            {isLoading && <div className="loading-indicator">AI is thinking...</div>}
            {error && <div className="error-message">Error: {error}</div>}

            <form onSubmit={handleSendPrompt} className="input-area">
                <input
                    type="text"
                    value={prompt}
                    onChange={(e) => setPrompt(e.target.value)}
                    placeholder="Ask Gemini anything..."
                    disabled={isLoading}
                />
                <button type="submit" disabled={isLoading}>
                    Send
                </button>
            </form>

            <div className="control-bar">
                <button
                    className="history-btn"
                    onClick={() => setShowHistory(!showHistory)}
                    disabled={isLoading}
                >
                    {showHistory ? "Hide History" : "Show History"}
                </button>
                <button
                    className="new-chat-btn"
                    onClick={startNewChat}
                    disabled={isLoading}
                >
                    New Chat
                </button>
            </div>
        </div>
    );
}

export default App;
