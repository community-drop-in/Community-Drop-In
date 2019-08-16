
console.log('js running');

const queue = new Queue();

queue.renderRecipients();

class Queue{

    renderRecipients(){
        this.getQueueDiv().addChild(
            document.createElement('div')
            .addAttribute('th:each', 'order: ${orders}')
            .classList.add('kitchen-sub-header')
            .addChild(
                document.createElement('h2')
                .addAttribute('th:text', "${order.hohFirstName} + ' ' + ${order.hohLastName}")
                .classList.add('recipient-kitchen-name')
            ).addChild(
                document.createElement('h2')
                .addAttribute('th:text', "${order.size}")
                .classList.add('recipient-kitchen-name')
            )
        )
    }
    getQueueDiv(){
        return document.querySelector('queue')
    }
}

{/* <div class='kitchen-sub-header' th:each="order: ${orders}">
        <h2 class='recipient-kitchen-name'th:text="${order.hohFirstName} + ' ' + ${order.hohLastName}"></h2>
        <h2 class='recipient-kitchen-house-size' th:text="${order.size}"></h2>
</div> */}

