console.log("js running");

class Queue {
  async renderRecipients() {
    await fetch("http://localhost:8080/queue")
      .then(response => response.text())
      .then(response => {
        document.querySelector("#queue").innerHTML = response;
      });
    document.querySelectorAll(".cancel-button").forEach(button => {
      button.addEventListener("click", e => {
        e.preventDefault();
        button.parentElement.parentElement.classList.toggle("hidden");
        alert("Order Canceled");
      });
    });
    document.querySelectorAll(".serve-button").forEach(button => {
      button.addEventListener("click", e => {
        e.preventDefault();
        button.parentElement.parentElement.classList.toggle("hidden");
        alert("Order Served");
      });
    });
  }

  deleteQueueOrder(id) {
    fetch(`http://localhost:8080/queue/delete/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json"
      }
    }).then(this.renderRecipients());
  }

  getQueueDiv() {
    return document.querySelector("#queue");
  }

  addCancelButtonEvent(id) {
    document.querySelectorAll(".cancel-button").forEach(button => {
      button.addEventListener("click", deleteQueueOrder(id));
    });
  }
}

const queue = new Queue();
setTimeout(queue.renderRecipients, 1000);

// onclick="deleteRecipient('${order.id}')"
