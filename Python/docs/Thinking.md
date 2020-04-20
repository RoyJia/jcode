# Django

## set_session cannot be used inside a transaction

### Case about Django BaseModel

> Overview

I saved some constant values into a table content_configuration, in a Python method, I did some steps in sequence like below

1. Create and save a parent table app_release record, to use app_release record id later
2. Query a constant value locales from content_configuration table, to use locales later
3. Create and save sub table mobile_app_task record which it contains app_release_id and locales

But when I run this method, I got `set_session cannot be used inside a transaction`, at the beginning, I thought that I should not do these steps(create and save record, query, create and save sub table recored again), it was acutally wrong thinking.

Also, when I did research by google with key text `django set_session cannot be used inside a transaction`, something it was pointed to psycopg2, seems it's true, psycopg2 has the same issue before, I wasted some time on that.

As my design, for sub table mobile_app_task, there are not fields like created_at, updated_at, created_by, updated_by. but these 4 attributes has been designed in the Django BaseModel, then I understand that every model will inherit this BaseModel's fields.

> Key Learn

1. When we are facing an issue, we should focus on exception logs firstly, and figure out that what exactly we are facing. Most time, we'll get resolution by this step.
2. When we do research by Google, must be careful the result, it is not match out problem everytime, otherwise you'll spend lots of time on unrelated things.
3. If I cannot solve the issue by the above 2 steps, I should ask help to some people who is more higher level and more experenced.
