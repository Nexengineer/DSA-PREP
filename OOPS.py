# ----------------------------------------------------------------
# In OOPs there are two classes, struct and objects.
# Every object has two characterstics 1) Attributes and 2) behaviour
# i.e A parrot object will have 
# 1) name, age, color are the attributes 
# 2) singing and dancing will be the behaviour
# ----------------------------------------------------------------

# Now from here onwards we will be discussing various elements
# of the object oriented programming 
# OOPs consists of 
# 1) Inheritance: This as common as we know it.
# 2) Encapsulation: This is similar to data abstraction and
#        simply means hiding the private details of the class 
#        from the other
# 3) Polymorphism: A common concept of using common operations 
#        with different objects as per requirement.

# ----------------------------------------------------------------
#  Creating class for bird
class Parrot:
    # Class attribute
    species = 'bird' # In swift we use static for class attribute

    # intiating Objects
    # instants attribute 
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    # instance method
    def sing(self, song):
        print('{} is sing song named {}'. format(self.name, song))
    
    def dance(self):
        print('{} is dancing'. format(self.name))

    

# Creating a bird object
#  List of operations performed
# obj = Parrot("Neeraj", 27)

# print("Species of bird is {}".format(obj.species))
# print("Name of bird is {}".format(obj.name))
# print("Age of bird is {}".format(obj.age))
# obj.sing('I am happy')
# obj.dance()

# ----------------------------------------------------------------

#  Now we will take about Inheritance
# This is the parent class
class Bird:
    def __init__(self):
        print('Bird is ready')
    
    def whoIsIt(self):
        print('Bird')

    def swim(self):
        print('swim faster')
    
# child class
class Penguin(Bird):
    def __init__(self):
        # super(self).__init__()
        print('Penguin is ready')

    def whoIsIt(self):
        print('Penguin')
    
    def run(self):
        print('Run Faster')

# Methods for using the above mentioned 
# obj = Penguin()
# obj.whoIsIt()
# obj.run()
# obj.swim()

# ----------------------------------------------------------------

# In this section we are going to study about the encapsulation
# In below mentioned problem we are basically not allowing the data to me modified directly
# NOTE: '__' this is used to declare the private variable in pyhton
class Computer:
    def __init__(self):
        self. __maxPrice = 0
    
    def sell(self):
        print('{} is max selling price'. format(self.__maxPrice))

    def changeMaxPrice(self, newPrice):
        self.__maxPrice = newPrice

# obj = Computer()
# obj.sell()
# obj.changeMaxPrice(100)
# obj.sell()

# ----------------------------------------------------------------
# Polymorphism can be acheived by Ovveriding and Overloading 

class Seagul:
    def fly(self):
        print('segul is flying')
    
    def swim(self):
        print('Seagul cannot swim')

class Ostrich:
    def fly(self):
        print('ostrich cannot fly')
    
    def swim(self):
        print('ostrich cannot swim')
        
def commonInterface(obj):
    obj.fly()
    obj.swim()

obj1 = Seagul()
obj2 = Ostrich()
commonInterface(obj1)
commonInterface(obj2)

# ----------------------------------------------------------------


