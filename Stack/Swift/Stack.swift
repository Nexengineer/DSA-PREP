// Linked list implementation of Stack
// Structure of the node in linked list 
class Node<T> {
    var data: T
    var prevNode: Node<T>?

    init(data: T) {
        self.data = data
    }
}

// Stack class expecting a generic value as a parameter
class StackLL<T> {
    var top: Node<T>?

    // Checking if Stack is empty
    func isEmpty() -> Bool{
        if top == nil {
            return true
        }
        return false
    }

    // Size of Stack
    func size() -> Int {
        var counter = 0 
        if var item = top {
            while item.prevNode != nil {
                counter = counter + 1
                item = item.prevNode!
            }
            return counter + 1
        }
        return counter
    }

    //Pushing in stack
    func push(_ value: T) {
        let newItem = Node<T>(data: value)
        newItem.prevNode = top
        top = newItem
    }

    // Poping the value from stack
    func pop(){
        if let item = top {
            top = item.prevNode!
        } else {
            print("Stack is empty")
        }
    }

    // function to print all the nodes
    func printLinkedList(){
        if var pointer = top {
            while pointer.prevNode != nil {
                print(pointer.data)
                pointer = pointer.prevNode!
            }
            print(pointer.data)
        } else {
            print("Stack is empty")
        }
    }
}

// Driver function
var stack = StackLL<String>()
stack.printLinkedList()
print(stack.size())
print("--------------------------------")
stack.push("Mishra")
stack.push("Kumar")
stack.push("Neeraj")
stack.push("Mr")
stack.push("Hello")
stack.printLinkedList()
print("--------------------------------")
stack.pop()
stack.pop()
stack.pop()
stack.pop()
stack.pop()
stack.printLinkedList()
