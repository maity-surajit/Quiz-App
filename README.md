## Quiz APP Detail..

### Question

Request Mapping : Question

1. GET: endpoint: /all_questions -> List All the questions
2. GET: endpoint: /category/{category} -> List the {category} questions (e.g: java/python).
3. POST: endpoint: /add -> Adding a new Question

Example of adding a new question - JSON Body:

    {
        "questionTitle": "Which is the Java 8 feature",
        "option1": "Functional interface",
        "option2": "Lamda",
        "option3": "Method Reference",
        "option4": "All of these",
        "rightAnswer": "All of these",
        "difficultyLevel": "Easy",
        "category": "java"
    }
5. DELETE: endpoint: remove/{id} -> Delete a question by id.
6. PUT: endpoint: update/{id} -> update a question by id
   
Example of updating a new question - JSON Body: 

    {
        "questionTitle": "Which is the Java 8 feature",
        "option1": "Functional interface",
        "option2": "Lamda",
        "option3": "Method Reference",
        "option4": "All of these",
        "rightAnswer": "All of these",
        "difficultyLevel": "Easy",
        "category": "java"
    }


### Quiz...

Request Mapping : Quiz

1. POST: endpoint: /create -> Create a new quiz.  (Creating a quiz it require three RequestParam 1. category: which category you want me to create a quiz 2. numQ: number of questions 3. title: title of the quiz)

Example: http://localhost:8080/quiz/create?category=java&numQ=4&title=JQuiz

2. GET: endpoint: /get/{id} -> Fetch the quiz
3. POST: endpoint: /submit/{id} -> Check the correct Answer of the quiz.

 Example: 

 
    [    {
            "id": 3,
            "response": "A built-in functio"
        },
        {
            "id": 9,
            "response": "64"
        },
        {
            "id": 13,
            "response": "O(n)"
        },
        {
            "id": 20,
            "response": "+"
        }
     ]   



