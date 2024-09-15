package com.majorproject.programmingquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majorproject.programmingquiz.databinding.FragmentQuizBinding;
import com.majorproject.programmingquiz.modelClass.QuizModel;
import com.majorproject.programmingquiz.modelClass.SubModel;

import java.util.ArrayList;
import java.util.Objects;
public class Quiz_Fragment extends Fragment {
    FragmentQuizBinding binding;
    ArrayList<QuizModel> list = new ArrayList<>();
    private int position = 0;
    int right = 0;
    private static String answer =null;
    int allQuestion;
    String listSize;
    String positionNo;
    QuizModel quizModel;
    String category, title;

    public Quiz_Fragment() {

    }
    public Quiz_Fragment(String category,String title) {
        this.category = category;
        this.title = title;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(getLayoutInflater());
        LoadQuestion();
        EnableOption();
        ClearOption();
        binding.nextBtn.setOnClickListener(v->{
            position++;
            LoadQuestion();
            EnableOption();
            ClearOption();
            CheckNext();
        });
        return binding.getRoot();
    }

    private void CheckNext() {
        if(position == allQuestion){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new Result_Fragment(right, allQuestion, category, title)).commit();
            list.clear();
            position = 0;
        }
    }

    private void ClearOption() {
        binding.Option1Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.Option1Cont.setTextColor(getContext().getColor(R.color.black));
        binding.Option2Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.Option2Cont.setTextColor(getContext().getColor(R.color.black));
        binding.Option3Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.Option3Cont.setTextColor(getContext().getColor(R.color.black));
        binding.Option4Cont.setBackgroundResource(R.drawable.sub_item_bg);
        binding.Option4Cont.setTextColor(getContext().getColor(R.color.black));
        binding.nextBtn.setBackgroundResource(R.drawable.disable_bg);
    }

    private void EnableOption() {
        binding.Option1Cont.setEnabled(true);
        binding.Option2Cont.setEnabled(true);
        binding.Option3Cont.setEnabled(true);
        binding.Option4Cont.setEnabled(true);
        binding.nextBtn.setEnabled(false);

    }

    private void LoadQuestion() {
        switch (title) {
            case "C BASIC":
                list.add(new QuizModel("1. What is the symbol used for the modulo operator in C?", "   a) %", "   b) *", "   c) /", "   d) &", "   a) %"));
                list.add(new QuizModel("2. Which loop in C will always execute at least once?", "   a) for loop", "   b) while loop", "   c) do-while loop", "   d) None of the above", "   c) do-while loop"));
                list.add(new QuizModel("3. What is the correct syntax for defining a function in C?", "   a) int functionName(arguments) {}", "   b) functionName(arguments) {}", "   c) int functionName() {}", "   d) functionName() {}", "   a) int functionName(arguments) {}"));
                list.add(new QuizModel("4. How do you declare a one-dimensional array in C?", "   a) int array[10];", "   b) array[10];", "   c) int array = {10};", "   d) None of the above", "   a) int array[10];"));
                list.add(new QuizModel("5. Which conditional statement is used to check multiple conditions in C?", "   a) if statement", "   b) switch statement", "   c) else statement", "   d) if-else-if ladder", "   d) if-else-if ladder"));
                list.add(new QuizModel("6. What is the correct syntax for the ternary operator in C?", "   a) ?", "   b) ?:", "   c) ::", "   d) //", "   b) ?:"));
                list.add(new QuizModel("7. Which operator is used for pointer dereferencing in C?", "   a) *", "   b) &", "   c) ->", "   d) ::", "   a) *"));
                list.add(new QuizModel("8. What is the purpose of the \"break\" statement in C?", "   a) To exit a loop or switch statement", "   b) To skip the remaining code in a loop and continue with the next iteration", "   c) To define a new case in a switch statement", "   d) None of the above", "   a) To exit a loop or switch statement"));
                list.add(new QuizModel("9. How do you pass arguments to a function in C (by default)?", "   a) By value", "   b) By reference", "   c) Both by value and by reference", "   d) Neither by value nor by reference", "   a) By value"));
                list.add(new QuizModel("10. Which of the following is not a valid C identifier?", "    a) myVariable", "    b) _variable", "    c) 123variable", "    d) variable123", "    c) 123variable"));
                setUp();
                break;
            case "C INTERMEDIATE":
                list.add(new QuizModel("1. Which of the following correctly declares a union in C?", "   a) `union myUnion { int a; float b; };`", "   b) `myUnion { int a; float b; };`", "   c) `typedef union { int a; float b; } myUnion;`", "   d) `union { int a; float b; } myUnion;`", "   a) `union myUnion { int a; float b; };`"));
                list.add(new QuizModel("2. What is the size of an empty structure in C?", "   a) 0 bytes", "   b) 1 byte", "   c) 4 bytes", "   d) 8 bytes", "   b) 1 byte"));
                list.add(new QuizModel("3. Which type casting method is preferred in C?", "   a) Implicit Casting", "   b) Explicit Casting", "   c) No casting needed", "   d) Conditional Casting", "   b) Explicit Casting"));
                list.add(new QuizModel("4. Which header file is required to use the `malloc()` and `free()` functions in C?", "    a) <stdlib.h>", "    b) <stdio.h>", "    c) <memory.h>", "    d) <malloc.h>", "    a) <stdlib.h>"));
                list.add(new QuizModel("5. What does the `->` operator do in C?", "    a) Accesses a member of a structure through a pointer", "    b) Compares two values", "    c) Allocates memory dynamically", "    d) Concatenates two strings", "    a) Accesses a member of a structure through a pointer"));
                list.add(new QuizModel("6. Which of the following is a valid way to declare a function pointer in C?", "    a) `int (*func_ptr)();`", "    b) `int *func_ptr();`", "    c) `int func_ptr();`", "    d) `int (*func_ptr[])();`", "    a) `int (*func_ptr)();`"));
                list.add(new QuizModel("7. Which of the following statements about unions is correct?", "a) Unions can contain members of different data types, but only one member can be accessed at a time.", "b) Unions cannot contain members of different data types.", "c) Unions can contain members of different data types, and all members can be accessed simultaneously.", "d) Unions can contain members of different data types, but they cannot be accessed.", "a) Unions can contain members of different data types, but only one member can be accessed at a time."));
                list.add(new QuizModel("8. Which of the following statements regarding recursion in C is correct?", "a) Recursion is always more efficient than iteration.", "b) Recursion is a process in which a function calls itself directly or indirectly.", "c) Recursion is not allowed in C.", "d) Recursion can only be used with void functions.", "b) Recursion is a process in which a function calls itself directly or indirectly."));
                list.add(new QuizModel("9. Which of the following statements is true about the scope of a variable in C?", "a) The scope of a variable defines the lifetime of the variable.", "b) A variable declared inside a function has global scope.", "c) A variable declared inside a block has local scope.", "d) The scope of a variable depends on its data type.", "c) A variable declared inside a block has local scope."));
                list.add(new QuizModel("10. What is the lifetime of a static variable in C?", "a) Until the end of the program", "b) Until the end of the block in which it is declared", "c) Until the function in which it is declared returns", "d) Until it is explicitly deallocated using free()", "a) Until the end of the program"));
                setUp();
                break;
            case "C ADVANCED":
                list.add(new QuizModel("1. Which of the following sorting algorithms has the best worst-case time complexity?", "a) Bubble Sort", "b) Insertion Sort", "c) Merge Sort", "d) Selection Sort", "c) Merge Sort"));
                list.add(new QuizModel("2. What is the time complexity of binary search?", "a) O(n)", "b) O(log n)", "c) O(n^2)", "d) O(1)", "b) O(log n)"));
                list.add(new QuizModel("3. In a multi-dimensional array arr[i][j], how is the memory organized?", "a) Contiguous memory locations for each row", "b) Contiguous memory locations for each column", "c) Non-contiguous memory locations", "d) Memory organization depends on the compiler", "a) Contiguous memory locations for each row"));
                list.add(new QuizModel("4. Which data structure is used to implement a linked list?", "a) Array", "b) Stack", "c) Queue", "d) Nodes", "d) Nodes"));
                list.add(new QuizModel("5. What is the time complexity of searching in a binary search tree (BST) in the worst case?", "a) O(n)", "b) O(log n)", "c) O(n log n)", "d) O(1)", "a) O(n)"));
                list.add(new QuizModel("6. Which of the following statements about macros in C is true?", "a) Macros cannot be used for recursion.", "b) Macros can be defined with the `inline` keyword.", "c) Macros are type-safe.", "d) Macros are expanded by the preprocessor before compilation.", "d) Macros are expanded by the preprocessor before compilation."));
                list.add(new QuizModel("7. What is the purpose of the `inline` function in C?", "a) To reduce code duplication", "b) To improve code readability", "c) To optimize function calls", "d) To ensure type safety", "c) To optimize function calls"));
                list.add(new QuizModel("8. Which of the following sorting algorithms is not stable?", "a) Insertion Sort", "b) Quick Sort", "c) Merge Sort", "d) Bubble Sort", "b) Quick Sort"));
                list.add(new QuizModel("9. What is the main advantage of a linked list over an array?", "a) Constant-time access to elements", "b) Cache locality", "c) Dynamic memory allocation", "d) Efficient use of memory", "c) Dynamic memory allocation"));
                list.add(new QuizModel("10. Which of the following operations can be performed efficiently on a binary search tree (BST)?", "a) Finding the kth smallest element", "b) Finding the maximum element", "c) Finding the median element", "d) Finding the sum of all elements", "a) Finding the kth smallest element"));
                setUp();
                break;


            case "C++ BASIC":
                list.add(new QuizModel("1. What is the purpose of a constructor in C++?", "a) To destroy objects", "b) To allocate memory for objects", "c) To initialize objects", "d) To declare member functions", "c) To initialize objects"));
                list.add(new QuizModel("2. Which of the following is true about pointers in C++?", "a) Pointers cannot be dereferenced", "b) Pointers cannot be used with arrays", "c) Pointers store the address of variables", "d) Pointers are not supported in C++", "c) Pointers store the address of variables"));
                list.add(new QuizModel("3. What is the purpose of the `new` operator in C++?", "a) To delete dynamically allocated memory", "b) To allocate memory for variables on the stack", "c) To allocate memory for variables on the heap", "d) To declare a new function", "c) To allocate memory for variables on the heap"));
                list.add(new QuizModel("4. Which of the following is true about references in C++?", "a) References cannot be reseated", "b) References cannot be used with arrays", "c) References store the value of variables", "d) References cannot be passed to functions", "a) References cannot be reseated"));
                list.add(new QuizModel("5. What is the purpose of a destructor in C++?", "a) To allocate memory for objects", "b) To initialize objects", "c) To perform cleanup tasks before an object is destroyed", "d) To declare member functions", "c) To perform cleanup tasks before an object is destroyed"));
                list.add(new QuizModel("6. What is the difference between an array and a pointer in C++?", "a) Arrays can store multiple values of different types, while pointers can only store addresses", "b) Arrays have fixed sizes, while pointers can dynamically resize", "c) Arrays cannot be passed to functions, while pointers can", "d) Arrays cannot be dereferenced, while pointers can", "b) Arrays have fixed sizes, while pointers can dynamically resize"));
                list.add(new QuizModel("7. Which of the following is an example of object-oriented programming (OOP) concept in C++?", "a) Inheritance", "b) Macros", "c) Typedef", "d) Switch-case statements", "a) Inheritance"));
                list.add(new QuizModel("8. What is the purpose of the `delete` operator in C++?", "a) To allocate memory for variables on the heap", "b) To deallocate dynamically allocated memory", "c) To initialize objects", "d) To delete member functions", "b) To deallocate dynamically allocated memory"));
                list.add(new QuizModel("9. What is the primary purpose of the `cin` function in C++?", "a) To output data to the console", "b) To input data from the console", "c) To declare a new class", "d) To allocate memory for variables", "b) To input data from the console"));
                list.add(new QuizModel("10. Which of the following is not a valid way to pass arguments to a function in C++?", "a) Pass by value", "b) Pass by reference", "c) Pass by pointer", "d) Pass by array", "d) Pass by array"));
                setUp();
                break;
            case "C++ INTERMEDIATE":
                list.add(new QuizModel("1. What is the purpose of the `new` and `delete` operators in C++?", "a) `new` is used to allocate memory for a single object on the heap, while `delete` is used to deallocate that memory.", "b) `new` is used to declare a new function, while `delete` is used to remove a function from memory.", "c) `new` is used to declare a new variable, while `delete` is used to delete a variable from memory.", "d) `new` and `delete` are used interchangeably to allocate and deallocate memory on the stack.", "a) `new` is used to allocate memory for a single object on the heap, while `delete` is used to deallocate that memory."));
                list.add(new QuizModel("2. In C++, what is operator overloading?", "a) Operator overloading is a technique used to define new operators in C++.", "b) Operator overloading is a technique used to redefine the behaviour of existing operators for user-defined types.", "c) Operator overloading is a technique used to restrict the use of certain operators in C++.", "d) Operator overloading is a technique used to optimize the performance of certain operators in C++.", "b) Operator overloading is a technique used to redefine the behaviour of existing operators for user-defined types."));
                list.add(new QuizModel("3. What is the access level of a derived class member inherited from its base class using public inheritance?", "a) Private", "b) Protected", "c) Public", "d) Depends on the specific case", "c) Public"));
                list.add(new QuizModel("4. Which of the following is not a file mode in C++ file handling?", "a) ios::in", "b) ios::out", "c) ios::append", "d) ios::delete", "d) ios::delete"));
                list.add(new QuizModel("5. What is the purpose of static_cast in C++?", "a) To perform dynamic type casting", "b) To perform explicit type conversion", "c) To perform implicit type conversion", "d) To perform downcasting", "b) To perform explicit type conversion"));
                list.add(new QuizModel("6. What is inheritance in C++?", "a) Inheritance is the process of creating multiple instances of a class.", "b) Inheritance is the process of reusing code by creating a new class that inherits properties and behaviours from an existing class.", "c) Inheritance is the process of hiding the implementation details of a class.", "d) Inheritance is the process of creating a subclass from a superclass.", "b) Inheritance is the process of reusing code by creating a new class that inherits properties and behaviours from an existing class."));
                list.add(new QuizModel("7. Which of the following is true about the protected access specifier in C++ inheritance?", "a) Protected members are accessible only within the same class.", "b) Protected members are accessible only within the same package.", "c) Protected members are accessible within the same class and its derived classes.", "d) Protected members are accessible everywhere in the program.", "c) Protected members are accessible within the same class and its derived classes."));
                list.add(new QuizModel("8. What is the purpose of the Standard Template Library (STL) in C++?", "a) To provide a set of standard data structures and algorithms", "b) To provide a set of standard input/output functions", "c) To provide a set of standard exception handling mechanisms", "d) To provide a set of standard macros and preprocessor directives", "a) To provide a set of standard data structures and algorithms"));
                list.add(new QuizModel("9. What is the role of the dynamic_cast operator in C++?", "a) To perform dynamic type casting between related classes in the inheritance hierarchy.", "b) To perform static type casting between unrelated classes.", "c) To perform dynamic memory allocation.", "d) To perform downcasting.", "a) To perform dynamic type casting between related classes in the inheritance hierarchy."));
                list.add(new QuizModel("10. Which container in the Standard Template Library (STL) provides constant-time insertion and removal of elements at both ends?", "a) vector", "b) list", "c) deque", "d) stack", "c) deque"));
                setUp();
                break;
            case "C++ ADVANCED":
                list.add(new QuizModel("1. What is multiple inheritance in C++?", "a) Multiple inheritance is the ability of a class to inherit from multiple base classes.", "b) Multiple inheritance is the process of inheriting multiple constructors from different classes.", "c) Multiple inheritance is the inheritance of multiple virtual functions from a single base class.", "d) Multiple inheritance is the inheritance of multiple static member variables from different classes.", "a) Multiple inheritance is the ability of a class to inherit from multiple base classes."));
                list.add(new QuizModel("2. What are move semantics in C++?", "a) Move semantics allow moving resources from one object to another efficiently without unnecessary copying.", "b) Move semantics allow moving resources from one object to another by making a deep copy.", "c) Move semantics allow moving resources from one object to another using a temporary buffer.", "d) Move semantics allow moving resources from one object to another by deleting the original object.", "a) Move semantics allow moving resources from one object to another efficiently without unnecessary copying."));
                list.add(new QuizModel("3. What is a lambda expression in C++?", "a) A lambda expression is a named function with a fixed number of arguments.", "b) A lambda expression is a special type of constructor used in C++.", "c) A lambda expression is an anonymous function that can capture variables from its surrounding scope.", "d) A lambda expression is a type of macro used to define inline functions.", "c) A lambda expression is an anonymous function that can capture variables from its surrounding scope."));
                list.add(new QuizModel("4. What is a function object in C++?", "a) A function object is a function declared inside a class.", "b) A function object is a pointer to a member function of a class.", "c) A function object is an instance of a class that overloads the function call operator ().", "d) A function object is a function defined outside of any class.", "c) A function object is an instance of a class that overloads the function call operator ()."));
                list.add(new QuizModel("5. What is multithreading in C++?", "a) Multithreading is the process of executing multiple threads simultaneously within a single process.", "b) Multithreading is the process of executing multiple processes simultaneously.", "c) Multithreading is the process of executing multiple functions simultaneously.", "d) Multithreading is the process of executing multiple constructors simultaneously.", "a) Multithreading is the process of executing multiple threads simultaneously within a single process."));
                list.add(new QuizModel("6. What is a thread in C++?", "a) A thread is a sequence of instructions executed by the CPU.", "b) A thread is a lightweight process that shares resources with other threads within the same process.", "c) A thread is a function defined inside a class.", "d) A thread is a pointer to a member function of a class.", "b) A thread is a lightweight process that shares resources with other threads within the same process."));
                list.add(new QuizModel("7. What is the purpose of std::mutex in C++ multithreading?", "a) std::mutex is used to lock and unlock critical sections of code to prevent concurrent access by multiple threads.", "b) std::mutex is used to create new threads in C++.", "c) std::mutex is used to terminate threads in C++.", "d) std::mutex is used to synchronize the execution of multiple functions.", "a) std::mutex is used to lock and unlock critical sections of code to prevent concurrent access by multiple threads."));
                list.add(new QuizModel("8. What is the purpose of std::condition_variable in C++ multithreading?", "a) std::condition_variable is used to wait for a condition to become true before proceeding with execution.", "b) std::condition_variable is used to signal the completion of a thread's execution.", "c) std::condition_variable is used to create new threads in C++.", "d) std::condition_variable is used to terminate threads in C++.", "a) std::condition_variable is used to wait for a condition to become true before proceeding with execution."));
                list.add(new QuizModel("9. What is the purpose of std::future in C++ multithreading?", "a) std::future is used to create new threads in C++.", "b) std::future is used to wait for the completion of a thread's execution and retrieve its result.", "c) std::future is used to signal the completion of a thread's execution.", "d) std::future is used to terminate threads in C++.", "b) std::future is used to wait for the completion of a thread's execution and retrieve its result."));
                list.add(new QuizModel("10. What is the purpose of std::atomic in C++ multithreading?", "a) std::atomic is used to perform atomic operations on shared variables, ensuring thread safety without the need for mutexes.", "b) std::atomic is used to create new threads in C++.", "c) std::thread::join() is used to signal the completion of a thread's execution.", "d) std::thread::join() is used to terminate a thread.", "a) std::atomic is used to perform atomic operations on shared variables, ensuring thread safety without the need for mutexes."));
                setUp();
                break;


            case "JAVA BASIC":
                list.add(new QuizModel("1. What is a class in Java?", "a) A class is a collection of variables.", "b) A class is a collection of objects.", "c) A class is a blueprint for creating objects.", "d) A class is a built-in data type in Java.", "c) A class is a blueprint for creating objects."));
                list.add(new QuizModel("2. What is an object in Java?", "a) An object is a collection of methods.", "b) An object is a collection of variables.", "c) An object is an instance of a class.", "d) An object is a keyword in Java.", "c) An object is an instance of a class."));
                list.add(new QuizModel("3. What is inheritance in Java?", "a) Inheritance is the process of creating multiple instances of a class.", "b) Inheritance is the process of reusing code by creating a new class that inherits properties and behaviors from an existing class.", "c) Inheritance is the process of hiding the implementation details of a class.", "d) Inheritance is the process of creating a subclass from a superclass.", "b) Inheritance is the process of reusing code by creating a new class that inherits properties and behaviors from an existing class."));
                list.add(new QuizModel("4. What is a method in Java?", "a) A method is a variable.", "b) A method is an object.", "c) A method is a function defined inside a class.", "d) A method is a class in Java.", "c) A method is a function defined inside a class."));
                list.add(new QuizModel("5. What is exception handling in Java?", "a) Exception handling is a process of handling syntax errors in Java programs.", "b) Exception handling is a process of handling runtime errors in Java programs.", "c) Exception handling is a process of handling logical errors in Java programs.", "d) Exception handling is a process of handling compilation errors in Java programs.", "b) Exception handling is a process of handling runtime errors in Java programs."));
                list.add(new QuizModel("6. What is the default access specifier in Java?", "a) private", "b) protected", "c) public", "d) package-private (default)", "d) package-private (default)"));
                list.add(new QuizModel("7. What is the purpose of the `toString()` method in Java?", "a) The `toString()` method is used to convert objects to strings.", "b) The `toString()` method is used to convert strings to objects.", "c) The `toString()` method is used to perform mathematical operations.", "d) The `toString()` method is used to access private variables.", "a) The `toString()` method is used to convert objects to strings."));
                list.add(new QuizModel("8. What is the purpose of the `super` keyword in Java?", "a) The `super` keyword is used to call the superclass constructor.", "b) The `super` keyword is used to access static variables.", "c) The `super` keyword is used to access private methods.", "d) The `super` keyword is used to declare a superclass.", "a) The `super` keyword is used to call the superclass constructor."));
                list.add(new QuizModel("9. What is method overloading in Java?", "a) Method overloading is the process of defining multiple methods with the same name but different signatures in the same class.", "b) Method overloading is the process of defining multiple methods with different names but the same signature in the same class.", "c) Method overloading is the process of defining multiple methods with the same name and signature in the same class.", "d) Method overloading is the process of defining multiple methods with the same name but different access specifiers in the same class.", "a) Method overloading is the process of defining multiple methods with the same name but different signatures in the same class."));
                list.add(new QuizModel("10. What is the purpose of the `this` keyword in Java?", "a) The `this` keyword is used to create new objects.", "b) The `this` keyword is used to access static members.", "c) The `this` keyword is used to refer to the current instance of the class.", "d) The `this` keyword is used to refer to the superclass.", "c) The `this` keyword is used to refer to the current instance of the class."));
                setUp();
                break;
            case "JAVA INTERMEDIATE":
                list.add(new QuizModel("1. What is multithreading in Java?", "a) Multithreading is the process of executing multiple methods simultaneously.", "b) Multithreading is the process of executing multiple programs simultaneously.", "c) Multithreading is the process of executing multiple threads simultaneously within a single program.", "d) Multithreading is the process of executing multiple objects simultaneously.", "c) Multithreading is the process of executing multiple threads simultaneously within a single program."));
                list.add(new QuizModel("2. What is synchronization in Java?", "a) Synchronization is the process of executing multiple methods simultaneously.", "b) Synchronization is the process of ensuring that only one thread can access a shared resource at a time.", "c) Synchronization is the process of ensuring that multiple threads always execute in a specific order.", "d) Synchronization is the process of terminating threads.", "b) Synchronization is the process of ensuring that only one thread can access a shared resource at a time."));
                list.add(new QuizModel("3. What is JDBC in Java?", "a) JDBC stands for Java Database Connector, which is used to connect Java applications with databases.", "b) JDBC stands for Java Data Binding and Conversion, which is used to convert data between different formats.", "c) JDBC stands for Java Data Configuration, which is used to configure data sources in Java applications.", "d) JDBC stands for Java Development Compiler, which is used to compile Java applications.", "a) JDBC stands for Java Database Connector, which is used to connect Java applications with databases."));
                list.add(new QuizModel("4. What is serialization in Java?", "a) Serialization is the process of converting objects into byte streams for storage or transmission.", "b) Serialization is the process of converting byte streams into objects.", "c) Serialization is the process of executing multiple methods simultaneously.", "d) Serialization is the process of terminating threads.", "a) Serialization is the process of converting objects into byte streams for storage or transmission."));
                list.add(new QuizModel("5. What is deserialization in Java?", "a) Deserialization is the process of converting byte streams into objects.", "b) Deserialization is the process of converting objects into byte streams for storage or transmission.", "c) Deserialization is the process of executing multiple methods simultaneously.", "d) Deserialization is the process of terminating threads.", "a) Deserialization is the process of converting byte streams into objects."));
                list.add(new QuizModel("6. What is ArrayList in Java?", "a) ArrayList is a resizable array implementation of the List interface in Java.", "b) ArrayList is a fixed-size array implementation of the List interface in Java.", "c) ArrayList is a linked list implementation of the List interface in Java.", "d) ArrayList is a hash table implementation of the List interface in Java.", "a) ArrayList is a resizable array implementation of the List interface in Java."));
                list.add(new QuizModel("7. What is LinkedList in Java?", "a) LinkedList is a resizable array implementation of the List interface in Java.", "b) LinkedList is a fixed-size array implementation of the List interface in Java.", "c) LinkedList is a linked list implementation of the List interface in Java.", "d) LinkedList is a hash table implementation of the List interface in Java.", "c) LinkedList is a linked list implementation of the List interface in Java."));
                list.add(new QuizModel("8. What is HashMap in Java?", "a) HashMap is a resizable array implementation of the Map interface in Java.", "b) HashMap is a fixed-size array implementation of the Map interface in Java.", "c) HashMap is a linked list implementation of the Map interface in Java.", "d) HashMap is a hash table implementation of the Map interface in Java.", "d) HashMap is a hash table implementation of the Map interface in Java."));
                list.add(new QuizModel("9. What is ConcurrentHashMap in Java?", "a) ConcurrentHashMap is a synchronized version of HashMap, providing thread-safe access to the underlying map.", "b) ConcurrentHashMap is a resizable array implementation of the Map interface in Java.", "c) ConcurrentHashMap is a linked list implementation of the Map interface in Java.", "d) ConcurrentHashMap is a hash table implementation of the Map interface in Java.", "a) ConcurrentHashMap is a synchronized version of HashMap, providing thread-safe access to the underlying map."));
                list.add(new QuizModel("10. What is TreeSet in Java?", "a) TreeSet is a resizable array implementation of the Set interface in Java.", "b) TreeSet is a linked list implementation of the Set interface in Java.", "c) TreeSet is a hash table implementation of the Set interface in Java.", "d) TreeSet is a sorted set implementation of the Set interface in Java.", "d) TreeSet is a sorted set implementation of the Set interface in Java."));
                setUp();
                break;
            case "JAVA ADVANCED":
                list.add(new QuizModel("1. What is JVM (Java Virtual Machine)?", "a) JVM is a compiler used to translate Java source code into bytecode.", "b) JVM is a hardware component responsible for executing Java bytecode.", "c) JVM is a virtual machine that provides the runtime environment for Java bytecode to execute.", "d) JVM is a garbage collector used to manage memory in Java programs.", "c) JVM is a virtual machine that provides the runtime environment for Java bytecode to execute."));
                list.add(new QuizModel("2. What is a design pattern in Java?", "a) Design pattern is a predefined algorithm used to solve common programming problems.", "b) Design pattern is a set of rules used to design user interfaces in Java applications.", "c) Design pattern is a reusable solution to a recurring design problem in software design.", "d) Design pattern is a built-in data structure in Java.", "c) Design pattern is a reusable solution to a recurring design problem in software design."));
                list.add(new QuizModel("3. What are concurrency utilities in Java?", "a) Concurrency utilities are tools used to manage memory allocation in Java programs.", "b) Concurrency utilities are tools used to manage network connections in Java programs.", "c) Concurrency utilities are tools used to manage multithreading and concurrent execution in Java programs.", "d) Concurrency utilities are tools used to manage database transactions in Java programs.", "c) Concurrency utilities are tools used to manage multithreading and concurrent execution in Java programs."));
                list.add(new QuizModel("4. What is thread safety in Java?", "a) Thread safety is the property of a Java program where only one thread can access a resource at a time.", "b) Thread safety is the property of a Java program where multiple threads can access a resource concurrently without causing data corruption.", "c) Thread safety is the property of a Java program where threads are terminated after executing their tasks.", "d) Thread safety is the property of a Java program where threads are synchronized using locks.", "b) Thread safety is the property of a Java program where multiple threads can access a resource concurrently without causing data corruption."));
                list.add(new QuizModel("5. What is the purpose of the synchronized keyword in Java?", "a) The synchronized keyword is used to declare a method as thread-safe.", "b) The synchronized keyword is used to create new threads in Java.", "c) The synchronized keyword is used to prevent deadlocks in Java programs.", "d) The synchronized keyword is used to define atomic blocks of code that are executed by only one thread at a time.", "d) The synchronized keyword is used to define atomic blocks of code that are executed by only one thread at a time."));
                list.add(new QuizModel("6. What is the purpose of the volatile keyword in Java?", "a) The volatile keyword is used to declare a method as thread-safe.", "b) The volatile keyword is used to create new threads in Java.", "c) The volatile keyword is used to prevent deadlocks in Java programs.", "d) The volatile keyword is used to indicate that a variable's value may be modified by multiple threads concurrently.", "d) The volatile keyword is used to indicate that a variable's value may be modified by multiple threads concurrently."));
                list.add(new QuizModel("7. What is garbage collection in Java?", "a) Garbage collection is a process of deallocating memory that is no longer in use by Java objects.", "b) Garbage collection is a process of allocating memory for Java objects.", "c) Garbage collection is a process of compressing memory in Java programs.", "d) Garbage collection is a process of terminating threads in Java programs.", "a) Garbage collection is a process of deallocating memory that is no longer in use by Java objects."));
                list.add(new QuizModel("8. What is the purpose of the finalize() method in Java?", "a) The finalize() method is used to terminate threads in Java programs.", "b) The finalize() method is used to handle exceptions in Java programs.", "c) The finalize() method is used to clean up resources before an object is garbage collected.", "d) The finalize() method is used to define atomic blocks of code that are executed by only one thread at a time.", "c) The finalize() method is used to clean up resources before an object is garbage collected."));
                list.add(new QuizModel("9. What is memory management in Java?", "a) Memory management is the process of managing the allocation and deallocation of memory resources in Java programs.", "b) Memory management is the process of managing network connections in Java programs.", "c) Memory management is the process of managing database transactions in Java programs.", "d) Memory management is the process of managing user interfaces in Java programs.", "a) Memory management is the process of managing the allocation and deallocation of memory resources in Java programs."));
                list.add(new QuizModel("10. What is the purpose of the SecurityManager class in Java?", "a) The SecurityManager class is used to manage database connections in Java programs.", "b) The SecurityManager class is used to manage memory resources in Java programs.", "c) The SecurityManager class is used to define security policies and control access to system resources in Java programs.", "d) The SecurityManager class is used to handle exceptions in Java programs.", "c) The SecurityManager class is used to define security policies and control access to system resources in Java programs."));
                setUp();
                break;


            case "PYTHON BASIC":
                list.add(new QuizModel("1. What is Python?", "a) Python is a high-level programming language.", "b) Python is a low-level programming language.", "c) Python is a hardware component.", "d) Python is an operating system.", "a) Python is a high-level programming language."));
                list.add(new QuizModel("2. Which of the following is NOT a control flow statement in Python?", "a) if-else", "b) for", "c) while", "d) function", "d) function"));
                list.add(new QuizModel("3. What is the purpose of the `if` statement in Python?", "a) The `if` statement is used for iteration.", "b) The `if` statement is used for exception handling.", "c) The `if` statement is used for decision-making.", "d) The `if` statement is used for function definition.", "c) The `if` statement is used for decision-making."));
                list.add(new QuizModel("4. What is the purpose of a function in Python?", "a) A function is used to define a block of code that can be reused.", "b) A function is used to create objects in Python.", "c) A function is used for decision-making.", "d) A function is used to handle exceptions.", "a) A function is used to define a block of code that can be reused."));
                list.add(new QuizModel("5. What is string manipulation in Python?", "a) String manipulation is the process of performing mathematical operations on strings.", "b) String manipulation is the process of converting strings to integers.", "c) String manipulation is the process of modifying, combining, or extracting parts of strings.", "d) String manipulation is the process of defining functions that operate on strings.", "c) String manipulation is the process of modifying, combining, or extracting parts of strings."));
                list.add(new QuizModel("6. Which of the following is a built-in function in Python?", "a) print()", "b) if", "c) while", "d) for", "a) print()"));
                list.add(new QuizModel("7. What are keywords in Python?", "a) Keywords are special words that represent predefined actions or meanings in Python.", "b) Keywords are variables that store data in Python.", "c) Keywords are used to define functions in Python.", "d) Keywords are used to handle exceptions in Python.", "a) Keywords are special words that represent predefined actions or meanings in Python."));
                list.add(new QuizModel("8. What is the purpose of the `def` keyword in Python?", "a) The `def` keyword is used to define a loop in Python.", "b) The `def` keyword is used to define a class in Python.", "c) The `def` keyword is used to define a function in Python.", "d) The `def` keyword is used to define an if statement in Python.", "c) The `def` keyword is used to define a function in Python."));
                list.add(new QuizModel("9. What is the purpose of the `return` statement in Python?", "a) The `return` statement is used to exit a loop.", "b) The `return` statement is used to define a function.", "c) The `return` statement is used to return a value from a function.", "d) The `return` statement is used to print output to the console.", "c) The `return` statement is used to return a value from a function."));
                list.add(new QuizModel("10. What is the purpose of the `len()` function in Python?", "a) The `len()` function is used to concatenate strings.", "b) The `len()` function is used to find the length of a list or string.", "c) The `len()` function is used to convert strings to integers.", "d) The `len()` function is used to define loops.", "b) The `len()` function is used to find the length of a list or string."));
                setUp();
                break;
            case "PYTHON INTERMEDIATE":
                list.add(new QuizModel("1. What is exception handling in Python?", "a) Exception handling is a mechanism to create custom exceptions.", "b) Exception handling is a process of handling runtime errors in Python programs.", "c) Exception handling is a process of terminating threads in Python programs.", "d) Exception handling is a process of defining functions that handle exceptions.", "b) Exception handling is a process of handling runtime errors in Python programs."));
                list.add(new QuizModel("2. What is an advanced data structure in Python?", "a) Advanced data structure refers to simple data types such as integers and strings.", "b) Advanced data structure refers to lists and tuples.w", "c) Advanced data structure refers to complex data types such as dictionaries, sets, and collections.", "d) Advanced data structure refers to basic data types such as integers and floats.", "c) Advanced data structure refers to complex data types such as dictionaries, sets, and collections."));
                list.add(new QuizModel("3. What are modules and packages in Python?", "a) Modules are built-in functions in Python, while packages are collections of modules.", "b) Modules are collections of functions and variables, while packages are single Python files.", "c) Modules are single Python files, while packages are collections of modules.", "d) Modules and packages are the same thing in Python.", "c) Modules are single Python files, while packages are collections of modules."));
                list.add(new QuizModel("4. What is concurrency in Python?", "a) Concurrency is the ability of a program to execute multiple tasks simultaneously.", "b) Concurrency is the ability of a program to handle exceptions gracefully.", "c) Concurrency is the process of serializing and deserializing objects.", "d) Concurrency is the process of handling network connections.", "a) Concurrency is the ability of a program to execute multiple tasks simultaneously."));
                list.add(new QuizModel("5. What is the difference between thread and multiprocessing in Python?", "a) Threads execute tasks concurrently within a single process, while multiprocessing involves multiple independent processes.", "b) Threads and multiprocessing are the same thing in Python.", "c) Threads and multiprocessing both involve executing tasks concurrently within a single process.", "d) Threads and multiprocessing both involve executing tasks sequentially.", "a) Threads execute tasks concurrently within a single process, while multiprocessing involves multiple independent processes."));
                list.add(new QuizModel("6. What is JSON parsing in Python?", "a) JSON parsing is the process of converting Python objects to JSON strings.", "b) JSON parsing is the process of converting JSON strings to Python objects.", "c) JSON parsing is the process of defining custom exceptions in Python.", "d) JSON parsing is the process of terminating threads in Python.", "b) JSON parsing is the process of converting JSON strings to Python objects."));
                list.add(new QuizModel("7. What is XML parsing in Python?", "a) XML parsing is the process of converting XML strings to Python objects.", "b) XML parsing is the process of defining custom exceptions in Python.", "c) XML parsing is the process of converting Python objects to XML strings.", "d) XML parsing is the process of terminating threads in Python.", "a) XML parsing is the process of converting XML strings to Python objects."));
                list.add(new QuizModel("8. What is the purpose of the `try-except` block in Python?", "a) The `try-except` block is used to define custom exceptions in Python.", "b) The `try-except` block is used to execute a block of code and handle exceptions gracefully.", "c) The `try-except` block is used to define functions in Python.", "d) The `try-except` block is used to create threads in Python.", "b) The `try-except` block is used to execute a block of code and handle exceptions gracefully."));
                list.add(new QuizModel("9. What is the purpose of the `finally` block in Python exception handling?", "a) The `finally` block is used to catch exceptions in Python programs.", "b) The `finally` block is used to handle exceptions in Python programs.", "c) The `finally` block is used to execute cleanup code regardless of whether an exception occurs or not.", "d) The `finally` block is used to ignore exceptions in Python programs.", "c) The `finally` block is used to execute cleanup code regardless of whether an exception occurs or not."));
                list.add(new QuizModel("10. What is the purpose of the `concurrent.futures` module in Python?", "a) The `concurrent.futures` module is used to define custom exceptions in Python.", "b) The `concurrent.futures` module is used to manage multiprocessing in Python.", "c) The `concurrent.futures` module is used to manage threading in Python.", "d) The `concurrent.futures` module is used to parse JSON and XML data in Python.", "b) The `concurrent.futures` module is used to manage multiprocessing in Python."));
                setUp();
                break;
            case "PYTHON ADVANCED":
                list.add(new QuizModel("1. What is database access in Python?", "a) Database access refers to connecting Python programs to web servers.", "b) Database access refers to connecting Python programs to external databases to perform CRUD operations.", "c) Database access refers to connecting Python programs to GUI frameworks.", "d) Database access refers to connecting Python programs to machine learning models.", "b) Database access refers to connecting Python programs to external databases to perform CRUD operations."));
                list.add(new QuizModel("2. What is web scraping in Python?", "a) Web scraping is the process of building graphical user interfaces in Python.", "b) Web scraping is the process of connecting Python programs to web servers.", "c) Web scraping is the process of extracting data from websites using Python scripts.", "d) Web scraping is the process of visualizing data in Python.", "c) Web scraping is the process of extracting data from websites using Python scripts."));
                list.add(new QuizModel("3. What is GUI programming in Python?", "a) GUI programming is the process of connecting Python programs to databases.", "b) GUI programming is the process of visualizing data in Python.", "c) GUI programming is the process of building graphical user interfaces for Python applications using libraries like Tkinter or PyQt.", "d) GUI programming is the process of connecting Python programs to machine learning models.", "c) GUI programming is the process of building graphical user interfaces for Python applications using libraries like Tkinter or PyQt."));
                list.add(new QuizModel("4. What is data visualization in Python?", "a) Data visualization is the process of connecting Python programs to databases.", "b) Data visualization is the process of extracting data from websites using Python scripts.", "c) Data visualization is the process of building graphical user interfaces in Python.", "d) Data visualization is the process of creating visual representations of data using libraries like Matplotlib or Seaborn.", "d) Data visualization is the process of creating visual representations of data using libraries like Matplotlib or Seaborn."));
                list.add(new QuizModel("5. What are ML and DS libraries in Python?", "a) ML and DS libraries are libraries used for connecting Python programs to databases.", "b) ML and DS libraries are libraries used for building graphical user interfaces in Python.", "c) ML and DS libraries are libraries used for visualizing data in Python.", "d) ML and DS libraries are libraries used for machine learning and data science tasks, such as scikit-learn, TensorFlow, and pandas.", "d) ML and DS libraries are libraries used for machine learning and data science tasks, such as scikit-learn, TensorFlow, and pandas."));
                list.add(new QuizModel("6. What is a web development framework in Python?", "a) A web development framework is a library used for connecting Python programs to databases.", "b) A web development framework is a library used for building graphical user interfaces in Python.", "c) A web development framework is a library used for visualizing data in Python.", "d) A web development framework is a collection of tools and libraries used for developing web applications, such as Django or Flask.", "d) A web development framework is a collection of tools and libraries used for developing web applications, such as Django or Flask."));
                list.add(new QuizModel("7. What is Django in Python?", "a) Django is a machine learning library in Python.", "b) Django is a database management system in Python.", "c) Django is a web development framework in Python.", "d) Django is a data visualization library in Python.", "c) Django is a web development framework in Python."));
                list.add(new QuizModel("8. What is Flask in Python?", "a) Flask is a machine learning library in Python.", "b) Flask is a database management system in Python.", "c) Flask is a web development framework in Python.", "d) Flask is a data visualization library in Python.", "c) Flask is a web development framework in Python."));
                list.add(new QuizModel("9. What is the purpose of SQLAlchemy in Python?", "a) SQLAlchemy is a machine learning library in Python.", "b) SQLAlchemy is a database management system in Python.", "c) SQLAlchemy is a web development framework in Python.", "d) SQLAlchemy is an SQL toolkit and Object-Relational Mapping (ORM) library for Python, providing a high-level API for working with databases.", "d) SQLAlchemy is an SQL toolkit and Object-Relational Mapping (ORM) library for Python, providing a high-level API for working with databases."));
                list.add(new QuizModel("10. What is the purpose of Scrapy in Python?", "a) Scrapy is a machine learning library in Python.", "b) Scrapy is a database management system in Python.", "c) Scrapy is a web scraping framework in Python, used for extracting data from websites.", "d) Scrapy is a web development framework in Python.", "c) Scrapy is a web scraping framework in Python, used for extracting data from websites."));
                setUp();
                break;
        }
    }

    private void setUp(){

        allQuestion = 10;
        listSize = String.valueOf(allQuestion);
        binding.totalQueNo.setText("/"+listSize);

        if(position != allQuestion) {
            positionNo = String.valueOf(position + 1);
            binding.QueNo.setText(positionNo);
        }
        else {
            positionNo = String.valueOf(position);
            binding.QueNo.setText(positionNo);
        }

        quizModel = list.get(position);
        answer = quizModel.getCorrectAns();
        binding.QuestionCont.setText(quizModel.getQuestion());
        binding.Option1Cont.setText(quizModel.getOp1());
        binding.Option2Cont.setText(quizModel.getOp2());
        binding.Option3Cont.setText(quizModel.getOp3());
        binding.Option4Cont.setText(quizModel.getOp4());
        optionCheck();
    }
    private void optionCheck() {
        binding.Option1Cont.setOnClickListener(v->{
            if(Objects.equals(quizModel.getOp1(), quizModel.getCorrectAns())){
                right++;
                binding.Option1Cont.setBackgroundResource(R.drawable.right_bg);
                binding.Option1Cont.setTextColor(getContext().getColor(R.color.white));

            }else{
                ShowRightAns();
                binding.Option1Cont.setBackgroundResource(R.drawable.wrong_bg);
                binding.Option1Cont.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
        binding.Option2Cont.setOnClickListener(v->{
            if(Objects.equals(quizModel.getOp2(), quizModel.getCorrectAns())){
                right++;
                binding.Option2Cont.setBackgroundResource(R.drawable.right_bg);
                binding.Option2Cont.setTextColor(getContext().getColor(R.color.white));

            }else {
                ShowRightAns();
                binding.Option2Cont.setBackgroundResource(R.drawable.wrong_bg);
                binding.Option2Cont.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
        binding.Option3Cont.setOnClickListener(v->{
            if(Objects.equals(quizModel.getOp3(), quizModel.getCorrectAns())){
                right++;
                binding.Option3Cont.setBackgroundResource(R.drawable.right_bg);
                binding.Option3Cont.setTextColor(getContext().getColor(R.color.white));

            }else{
                ShowRightAns();
                binding.Option3Cont.setBackgroundResource(R.drawable.wrong_bg);
                binding.Option3Cont.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
        binding.Option4Cont.setOnClickListener(v->{
            if(Objects.equals(quizModel.getOp4(), quizModel.getCorrectAns())){
                right++;
                binding.Option4Cont.setBackgroundResource(R.drawable.right_bg);
                binding.Option4Cont.setTextColor(getContext().getColor(R.color.white));
            }else{
                ShowRightAns();
                binding.Option4Cont.setBackgroundResource(R.drawable.wrong_bg);
                binding.Option4Cont.setTextColor(getContext().getColor(R.color.white));

            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
    }
    private void DisableOption() {
        binding.Option1Cont.setEnabled(false);
        binding.Option2Cont.setEnabled(false);
        binding.Option3Cont.setEnabled(false);
        binding.Option4Cont.setEnabled(false);
        binding.nextBtn.setEnabled(true);

    }
    private void ShowRightAns() {
        if(Objects.equals(quizModel.getOp1(), quizModel.getCorrectAns())){
            binding.Option1Cont.setBackgroundResource(R.drawable.right_bg);
            binding.Option1Cont.setTextColor(getContext().getColor(R.color.white));
        }else if(Objects.equals(quizModel.getOp2(), quizModel.getCorrectAns())){
            binding.Option2Cont.setBackgroundResource(R.drawable.right_bg);
            binding.Option2Cont.setTextColor(getContext().getColor(R.color.white));
        }else if(Objects.equals(quizModel.getOp3(), quizModel.getCorrectAns())){
            binding.Option3Cont.setBackgroundResource(R.drawable.right_bg);
            binding.Option3Cont.setTextColor(getContext().getColor(R.color.white));
        }else if(Objects.equals(quizModel.getOp4(), quizModel.getCorrectAns())){
            binding.Option4Cont.setBackgroundResource(R.drawable.right_bg);
            binding.Option4Cont.setTextColor(getContext().getColor(R.color.white));
        }


    }
}