class Task:
    def __init__(self, task_id, title, description):
        self.task_id = task_id
        self.title = title
        self.description = description

    def __str__(self):
        return f"ID: {self.task_id}, Title: {self.title}, Description: {self.description}"

def display_tasks(task_list):
    if not task_list:
        print("No tasks available.")
        return
    print("Tasks List:")
    for task in task_list:
        print(task)

def create_task(task_list):
    task_id = len(task_list) + 1
    title = input("Enter task title: ")
    description = input("Enter task description: ")
    new_task = Task(task_id, title, description)
    task_list.append(new_task)
    print(f"Task '{title}' created successfully.")

def read_task(task_list):
    task_id = int(input("Enter the task ID to view: "))
    for task in task_list:
        if task.task_id == task_id:
            print(task)
            return
    print("Task not found.")

def update_task(task_list):
    task_id = int(input("Enter the task ID to update: "))
    for task in task_list:
        if task.task_id == task_id:
            task.title = input("Enter new task title: ")
            task.description = input("Enter new task description: ")
            print(f"Task '{task_id}' updated successfully.")
            return
    print("Task not found.")

def delete_task(task_list):
    task_id = int(input("Enter the task ID to delete: "))
    for i, task in enumerate(task_list):
        if task.task_id == task_id:
            del task_list[i]
            print(f"Task '{task_id}' deleted successfully.")
            return
    print("Task not found.")

def run_application():
    task_list = []
    while True:
        print("\n1. View Tasks\n2. Create Task\n3. Read Task\n4. Update Task\n5. Delete Task\n6. Exit")
        choice = input("Choose an option: ")

        if choice == "1":
            display_tasks(task_list)
        elif choice == "2":
            create_task(task_list)
        elif choice == "3":
            read_task(task_list)
        elif choice == "4":
            update_task(task_list)
        elif choice == "5":
            delete_task(task_list)
        elif choice == "6":
            print("Exiting application.")
            break
        else:
            print("Invalid choice. Please try again.")

# Run the application
run_application()
