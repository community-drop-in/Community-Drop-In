console.log("js running");

class Queue {
  renderRecipients() {
    fetch("http://localhost:8080/queue")
      .then(response => response.text())
      .then(response => {
        document.querySelector("#queue").innerHTML = response;
      });
  }

  getQueueDiv() {
    return document.querySelector("#queue");
  }
}

const queue = new Queue();
setTimeout(queue.renderRecipients, 3000);

// while (true) {
//   console.log("loop ran");
// }
