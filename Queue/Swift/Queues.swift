// Linked list implementation of queues
// Node implementation
class Node<T> {
    var data: T
    var nextNode: Node<T>?

    init(data: T) {
        self.data = data
    }    
}

// Implementation of queue
class Queue<T>{
    var front: Node<T>?
    var rear: Node<T>?

    // Check if queue is empty
    func isEmpty() -> Bool{
        if front == nil || rear == nil {
            return true
        }
        return false
    }

    // Adding the data to 
    func enqueue(_ data: T) {
        let item = Node<T>(data: data)
        item.nextNode = nil
        if let temp = rear {
            temp.nextNode = item
            rear = item
            return
        }
        front = item
        rear = item
    }

    func dequeue(){
        if let temp = front {
            if temp.nextNode == nil {
                front = nil
                rear = nil
            } else {
                front = temp.nextNode!
            }
        } else {
            print("queue is empty")
        }
    }
    
    // Printing all the nodes
    func printLinkedList(){
        if var pointer = front {
            while pointer.nextNode != nil {
                print(pointer.data)
                pointer = pointer.nextNode!
            }
            print(pointer.data)
        } else {
            print("linked List is empty")
        }
    }
}

// Driver function
var queue = Queue<String>()
queue.printLinkedList()
print(queue.isEmpty())
print("--------------------------------")
queue.enqueue("Neeraj")
queue.enqueue("Kumar")
queue.enqueue("Mishra")
queue.printLinkedList()
print("--------------------------------")
queue.dequeue()
print(queue.isEmpty())
queue.printLinkedList()
print("--------------------------------")
queue.dequeue()
print(queue.isEmpty())
queue.printLinkedList()
print("--------------------------------")
queue.dequeue()
print(queue.isEmpty())
queue.printLinkedList()
