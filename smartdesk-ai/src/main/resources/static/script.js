const messageInput = document.getElementById("messageInput");
const sendButton = document.getElementById("sendButton");
const chatMessages = document.getElementById("chatMessages");


// Send message when button is clicked
sendButton.addEventListener("click", sendMessage);


// Send message when Enter key is pressed
messageInput.addEventListener("keydown", function (event) {

    if (event.key === "Enter") {
        sendMessage();
    }

});


// Send quick-question button message
function sendQuickMessage(message) {

    messageInput.value = message;

    sendMessage();

}


// Send message to chatbot
async function sendMessage() {

    const message = messageInput.value.trim();

    // Don't send empty messages
    if (message === "") {
        return;
    }


    // Display user's message
    addMessage(message, "user");

    // Clear input
    messageInput.value = "";


    // Show typing indicator
    const typingMessage = addTypingIndicator();


    try {

        const response = await fetch(
            `/api/chat?message=${encodeURIComponent(message)}`
        );


        if (!response.ok) {
            throw new Error("Server error");
        }


        const botResponse = await response.text();


        // Remove typing indicator
        typingMessage.remove();


        // Display bot response
        addMessage(botResponse, "bot");


    } catch (error) {

        typingMessage.remove();

        addMessage(
            "Sorry, I couldn't connect to the SmartDesk AI server. Please try again.",
            "bot"
        );

        console.error(error);

    }

}


// Add normal chat message
function addMessage(text, sender) {

    const message = document.createElement("div");

    message.className = `message ${sender}`;


    const content = document.createElement("div");

    content.className = "message-content";


    const messageText = document.createElement("div");

    messageText.textContent = text;


    const time = document.createElement("span");

    time.className = "message-time";

    time.textContent = getCurrentTime();


    content.appendChild(messageText);
    content.appendChild(time);

    message.appendChild(content);

    chatMessages.appendChild(message);


    scrollToBottom();


    return message;

}


// Add typing indicator
function addTypingIndicator() {

    const message = document.createElement("div");

    message.className = "message bot";


    const content = document.createElement("div");

    content.className = "message-content typing";


    content.innerHTML = `
        <span class="typing-dot"></span>
        <span class="typing-dot"></span>
        <span class="typing-dot"></span>
    `;


    message.appendChild(content);

    chatMessages.appendChild(message);


    scrollToBottom();


    return message;

}


// Scroll chat to bottom
function scrollToBottom() {

    const container = document.querySelector(".chat-container");

    container.scrollTop = container.scrollHeight;

}


// Get current time
function getCurrentTime() {

    const now = new Date();

    return now.toLocaleTimeString([], {
        hour: "2-digit",
        minute: "2-digit"
    });

}
// Theme toggle

const themeButton = document.getElementById("themeButton");

themeButton.addEventListener("click", function () {

    document.body.classList.toggle("dark-mode");

    if (document.body.classList.contains("dark-mode")) {

        themeButton.textContent = "☀️";
        themeButton.title = "Switch to light mode";

    } else {

        themeButton.textContent = "🌙";
        themeButton.title = "Switch to dark mode";

    }

});