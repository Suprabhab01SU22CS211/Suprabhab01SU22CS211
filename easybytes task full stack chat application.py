import http.server
import socketserver
from urllib.parse import urlparse

PORT = 8000

# HTML content for the chat interface
HTML_CONTENT = '''
<!DOCTYPE html>
<html>
<head>
    <title>Simple Chat</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .chat-container { width: 80%; margin: auto; }
        .messages { border: 1px solid #ccc; padding: 10px; height: 300px; overflow-y: scroll; }
        .message { padding: 5px; border-bottom: 1px solid #eee; }
        .input { margin-top: 10px; }
    </style>
</head>
<body>
    <div class="chat-container">
        <div class="messages">
            <!-- Messages will be displayed here -->
        </div>
        <form id="chat-form" class="input">
            <input type="text" id="message" required>
            <button type="button" onclick="sendMessage()">Send</button>
        </form>
    </div>
    <script>
        function sendMessage() {
            const message = document.getElementById('message').value;
            if (message) {
                const messagesDiv = document.querySelector('.messages');
                const messageDiv = document.createElement('div');
                messageDiv.className = 'message';
                messageDiv.textContent = message;
                messagesDiv.appendChild(messageDiv);
                document.getElementById('message').value = '';
            }
        }
    </script>
</body>
</html>
'''

class MyRequestHandler(http.server.BaseHTTPRequestHandler):
    def do_GET(self):
        if self.path == '/':
            self.send_response(200)
            self.send_header('Content-type', 'text/html')
            self.end_headers()
            self.wfile.write(HTML_CONTENT.encode('utf-8'))
        else:
            self.send_response(404)
            self.end_headers()

    def do_POST(self):
        self.send_response(405)
        self.send_header('Content-type', 'text/html')
        self.end_headers()

with socketserver.TCPServer(("", PORT), MyRequestHandler) as httpd:
    print(f"Serving at port {PORT}")
    httpd.serve_forever()
