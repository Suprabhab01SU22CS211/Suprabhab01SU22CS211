import random
import string

def generate_password(length, use_uppercase, use_lowercase, use_digits, use_symbols):
    # Create a list to store the types of characters to include in the password
    character_pool = []
    
    if use_uppercase:
        character_pool.extend(string.ascii_uppercase)
    if use_lowercase:
        character_pool.extend(string.ascii_lowercase)
    if use_digits:
        character_pool.extend(string.digits)
    if use_symbols:
        character_pool.extend(string.punctuation)

    # Ensure the character pool is not empty
    if not character_pool:
        raise ValueError("At least one character type must be selected!")

    # Generate the password by randomly choosing characters from the pool
    password = ''.join(random.choice(character_pool) for _ in range(length))

    return password

def main():
    print("Welcome to the Password Generator!")

    # Prompt the user to specify the desired length of the password
    while True:
        try:
            length = int(input("Enter the desired length of the password: "))
            if length < 1:
                print("Password length should be at least 1.")
            else:
                break
        except ValueError:
            print("Please enter a valid number.")

    # Ask the user to specify the types of characters to include
    use_uppercase = input("Include uppercase letters? (y/n): ").strip().lower() == 'y'
    use_lowercase = input("Include lowercase letters? (y/n): ").strip().lower() == 'y'
    use_digits = input("Include digits? (y/n): ").strip().lower() == 'y'
    use_symbols = input("Include symbols? (y/n): ").strip().lower() == 'y'

    # Generate and display the password
    try:
        password = generate_password(length, use_uppercase, use_lowercase, use_digits, use_symbols)
        print(f"Generated password: {password}")
    except ValueError as e:
        print(f"Error: {e}")

# Call the main function
if __name__ == "__main__":
    main()
