import login # Access full profile data
import csv
import pandas as pd


profile = login.host.profile("theskagency")
posts = login.host.posts(username="theskagency", count=35)

arr = []

for this_post in posts:
    if this_post is None:
        print("No post found")
    else:
        url = this_post.share_url
        arr.append(url)
with open('testing.csv', 'w', newline='') as file:
    writer = csv.writer(file, delimiter = ",", lineterminator='\n')
    writer.writerow(arr)

df = pd.DataFrame(arr, columns=['urls'])

print(df)

