class AdminQueue {
    renderRecipients() {
        fetch("http://localhost:8080/queue")
          .then(response => response.text())
          .then(response => {
            document.querySelector(".lobby-queue-app").innerHTML = response;
          });
    }

    
}

const queue = new AdminQueue()
setTimeout(queue.renderRecipients, 3000)