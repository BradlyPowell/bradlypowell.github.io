# Python Quiz Game — High School Friendly
# Run: python quiz.py

import sys

QUESTIONS = [
    {
        "q": "Which language is primarily taught in AP Computer Science A?",
        "choices": ["A) Python", "B) Java", "C) C++", "D) JavaScript"],
        "answer": "B",
        "explain": "AP CSA focuses on Java, while AP CSP is broader and language-flexible."
    },
    {
        "q": "What does HTML stand for?",
        "choices": ["A) HyperText Markup Language", "B) High Transfer Machine Learning", "C) Hyperlink and Text Management Language", "D) Home Tool Markup Language"],
        "answer": "A",
        "explain": "HTML is the standard markup language for web pages."
    },
    {
        "q": "Which of these is a version control system commonly used by developers?",
        "choices": ["A) Git", "B) Excel", "C) Photoshop", "D) Zoom"],
        "answer": "A",
        "explain": "Git tracks changes in source code and enables collaboration."
    },
    {
        "q": "In Python, what does 'print()' do?",
        "choices": ["A) Reads a file", "B) Displays output to the console", "C) Saves a file", "D) Quits the script"],
        "answer": "B",
        "explain": "print() sends text output to the terminal/console."
    },
    {
        "q": "Which of the following best describes a 'loop' in programming?",
        "choices": ["A) A variable that holds text", "B) A repeated block of code", "C) A function that returns nothing", "D) A single line comment"],
        "answer": "B",
        "explain": "Loops repeat code while a condition holds or over a sequence."
    }
]

def ask_question(i, data):
    print(f"\nQ{i+1}. {data['q']}")
    for c in data["choices"]:
        print(c)
    while True:
        guess = input("Your answer (A/B/C/D): ").strip().upper()
        if guess in {"A","B","C","D"}:
            return guess
        print("Please enter A, B, C, or D.")

def run_quiz():
    print("=== Bradly's CS Quiz ===")
    score = 0
    for i, q in enumerate(QUESTIONS):
        ans = ask_question(i, q)
        if ans == q["answer"]:
            print("✅ Correct!")
            score += 1
        else:
            print(f"❌ Incorrect. Correct answer: {q['answer']}")
        print("Explanation:", q["explain"])
    print(f"\nYour score: {score}/{len(QUESTIONS)}")
    return score

def main():
    while True:
        score = run_quiz()
        again = input("\nPlay again? (y/n): ").strip().lower()
        if again != "y":
            print("Thanks for playing!")
            sys.exit(0)

if __name__ == "__main__":
    main()
