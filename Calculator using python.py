def calculator():
    # Prompt the user to input two numbers
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))

    # Perform all operations and display the results
    print("\nResults:")
    
    # Addition
    addition = num1 + num2
    print(f"{num1} + {num2} = {addition}")

    # Subtraction
    subtraction = num1 - num2
    print(f"{num1} - {num2} = {subtraction}")

    # Multiplication
    multiplication = num1 * num2
    print(f"{num1} * {num2} = {multiplication}")

    # Division
    if num2 != 0:
        division = num1 / num2
        print(f"{num1} / {num2} = {division}")
    else:
        print(f"{num1} / {num2} = Error (Division by zero is not allowed!)")

# Call the calculator function to run the program
calculator()
