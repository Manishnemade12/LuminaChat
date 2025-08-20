import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react(),],

  server: { // Add this server configuration
    proxy: {
      // String shorthand for simple cases: '/api': 'http://localhost:8080'
      // With options: http://localhost:5173/gemini-ai-wrapper/v1/chat -> http://localhost:8080/gemini-ai-wrapper/v1/chat
      '/gemini-ai-wrapper': {
        target: 'http://localhost:8080', // Your Spring Boot backend address
        changeOrigin: true, // Needed for virtual hosted sites
        // secure: false, // Uncomment if your backend uses HTTPS with a self-signed certificate
        // rewrite: (path) => path.replace(/^\/api/, '') // Uncomment if you need to rewrite the path
      }
    }
  }
})