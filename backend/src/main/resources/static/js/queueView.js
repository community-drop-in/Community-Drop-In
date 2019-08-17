console.log("js running");

class Queue {
  renderRecipients() {
    fetch("http://localhost:8080/queue")
      .then(response => response.text())
      .then(response => {
        document.querySelector("#queue").innerHTML = response;
        document.querySelectorAll(".cancel-button").forEach(button => {
          button.addEventListener("click", deleteQueueOrder(response.id));
        });
      });
  }

  deleteQueueOrder(id) {
    fetch(`http://localhost:8080/queue/delete`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ id: `${id}` })
    }).then(this.renderRecipients());
  }

  getQueueDiv() {
    return document.querySelector("#queue");
  }

  // addCancelButtonEvent(id) {

  // }
}

const queue = new Queue();
setTimeout(queue.renderRecipients, 1000);

// onclick="deleteRecipient('${order.id}')"
