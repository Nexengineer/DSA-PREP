// This is the structure of Doubly Linked list
// We have place for storing the front and rear pointer
class Node<T> {
    var value: T
    var prevNode: Node<T>?
    var nextNode: Node<T>?
    
    init(value: T) {
        self.value = value
    } 
}

// Doubly Linked list implementation
class DoublyLinkedList<T>{
    var head: Node<T>?
    
    // This is to check, if linked list has some element or not 
    func isEmpty() -> Bool {
        if head == nil {
            return true
        }
        return false
    }

    // This is the length of the doubly linked list.
    func size() -> Int {
        var size = 0
        if var node = head {
            while node.nextNode != nil {
                size = size + 1
                node = node.nextNode!
            }
            return size + 1
        }
        return 0
    }

    // This is to add element
    func append( _ value: T) {
        let newNode = Node<T>(value: value)
        newNode.nextNode = nil
        newNode.prevNode = nil
        if var node = head {
            while node.nextNode != nil {
                node = node.nextNode!
            }
            newNode.prevNode = node
            node.nextNode = newNode
            return
        }
        head = newNode
    }

    func delete(_ at: Int) {
        if at >= size() || head == nil {
            print("Index out of bond")
        } else {
            var counter = 0
            if var node = head {
                while(counter != at){
                    counter = counter + 1
                    node = node.nextNode!
                }
                let tempNode = node.prevNode!
                if let nextDataNode = node.nextNode {
                    nextDataNode.prevNode = tempNode
                    tempNode.nextNode = nextDataNode
                } else {
                    tempNode.nextNode = nil
                }
            }
        }
    }

    // function to print all the nodes
    func printLinkedList(){
        if var pointer = head {
            while pointer.nextNode != nil {
                print(pointer.value)
                pointer = pointer.nextNode!
            }
            print(pointer.value)
        } else {
            print("linked List is empty")
        }
    }
}

// Driver function
var linkedList = DoublyLinkedList<String>()
linkedList.printLinkedList()
linkedList.append("Neeraj")
linkedList.append("Kumar")
linkedList.append("Mishra")
linkedList.printLinkedList()
print(linkedList.size())
print("--------------------------------")
linkedList.delete(1)
linkedList.printLinkedList()
print(linkedList.size())
