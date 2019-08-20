console.log("js running");

class Queue {
  constructor() {
    console.log(this);
    this.self = this;
  }

  renderRecipients() {
    fetch("http://localhost:8080/queue")
      .then(response => response.text())
      .then(response => {
        document.querySelector("#queue").innerHTML = response;
        document.querySelectorAll(".cancel-button").forEach(button => {
          button.addEventListener("click", e => {
            e.preventDefault();
            const inputId = document.querySelector(".id-input").value;
            fetch("http://localhost:8080/queue/delete/" + inputId, {
              method: "DELETE"
            });
          });
        });
        document.querySelectorAll(".serve-button").forEach(button => {
          button.addEventListener("click", e => {
            e.preventDefault();
            const inputId = document.querySelector(".id-input").value;
            fetch("http://localhost:8080/queue/delete/" + inputId, {
              method: "DELETE"
            });
          });
        });
      });
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

window.setInterval(function() {
  setTimeout(queue.renderRecipients, 1000);
  console.log("Orders refreshed");
}, 1000);
