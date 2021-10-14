#include <bits/stdc++.h>
using namespace std;
int S[1000];
int top;
void push(int x)
{
    top++;
    S[top] = x;
}
int pop()
{
    top--;
    return S[top + 1];
}
int main()
{
    int a, b;
    char s[100];
    top = 0;
    while (scanf("%s", s) != EOF)
    {
        if (s[0] == '+')
        {
            a = pop();
            b = pop();
            push(a + b);
        }
        else if (s[0] == '-')
        {
            a = pop();
            b = pop();
            push(a - b);
        }
        else if (s[0] == '*')
        {
            a = pop();
            b = pop();
            push(a * b);
        }
        else
        {
            push(atoi(s));
        }
    }
    printf("%d\n", pop());
}