"""
Below are some problems related to recursion in python, you can check the logic and flowchart of these problems from the website refered below:
> https://www.w3resource.com/python-exercises/data-structures-and-algorithms/python-recursion.php

"""
'''
Ques1) Write a Python program to calculate the sum of a list of numbers.
Code-> 
'''
def list_sum(num_List):
    if len(num_List) == 1:
        return num_List[0]
    else:
        return num_List[0] + list_sum(num_List[1:])
        
print(list_sum([2, 4, 5, 6, 7]))

'''
Ques2)Write a Python program to converting an Integer to a string in any base.
Code->
'''
def to_string(n,base):
   conver_tString = "0123456789ABCDEF"
   if n < base:
      return conver_tString[n]
   else:
      return to_string(n//base,base) + conver_tString[n % base]

print(to_string(2835,16))

'''
Ques3)Write a Python program to solve the Fibonacci sequence using recursion.
Code->
'''
def fibonacci(n):
  if n == 1 or n == 2:
    return 1
  else:
    return (fibonacci(n - 1) + (fibonacci(n - 2)))

print(fibonacci(7))

'''
Ques4)Write a Python program to calculate the value of 'a' to the power 'b'.
Code->
'''
def power(a,b):
	if b==0:
		return 1
	elif a==0:
		return 0
	elif b==1:
		return a
	else:
		return a*power(a,b-1)

print(power(3,4))


'ps: I do not own the content above and have been able to present it from the link refered above.'


