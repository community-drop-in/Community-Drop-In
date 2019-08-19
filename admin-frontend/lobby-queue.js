class LobbyQueue {

    renderRecipients() {
      fetch("http://localhost:8080/queue")
        .then(response => response.text())
        .then(response => {
          document.querySelector(".lobby-queue-app").innerHTML = response;
        });
    }
}

const queue = new LobbyQueue()
setTimeout(queue.renderRecipients, 3000)