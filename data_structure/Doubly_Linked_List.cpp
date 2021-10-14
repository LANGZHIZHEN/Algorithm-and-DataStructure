#include <bits/stdc++.h>
using namespace std;
struct Node
{
    int key;
    Node *prev, *next;
};
Node *nil;
void init()
{
    nil = (Node *)malloc(sizeof(Node));
    nil->prev = nil;
    nil->next = nil;
}
void Insert(int key)
{
    Node *item = (Node *)malloc(sizeof(Node));
    item->key = key;
    item->next = nil->next;
    nil->next->prev = item;
    nil->next = item;
    item->prev = nil;
}
Node *listSearch(int key)
{
    Node *cur = nil->next;
    while (cur->key != key && cur != nil)
    {
        cur = cur->next;
    }
    return cur;
}
void Delete(Node *t)
{
    if (t == nil)
        return;
    t->prev->next = t->next;
    t->next->prev = t->prev;
    free(t);
}
void deleteFirst()
{
    Delete(nil->next);
}
void deleteLast()
{
    Delete(nil->prev);
}
void deleteKey(int key)
{
    Delete(listSearch(key));
}
void print()
{
    Node *t = nil->next;
    int i = 0;
    while (t != nil)
    {
        if (i > 0)
            printf(" ");
        printf("%d", t->key);
        i++;
        t = t->next;
    }
    printf("\n");
}
int main()
{
    int n;
    char com[20];
    int key;
    scanf("%d", &n);
    init();
    for (int i = 0; i < n; i++)
    {
        scanf("%s%d", com, &key);
        if (com[0] == 'i')
            Insert(key);
        else if (com[0] == 'd')
        {
            if (strlen(com) > 7)
            {
                if (com[6] == 'F')
                    deleteFirst();
                else
                    deleteLast();
            }
            else
                deleteKey(key);
        }
    }
    print();
    return 0;
}