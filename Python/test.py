import login # Access full profile data
if login.profile is None:
    print("Unable to fetch user data")
else:
    user_id = login.profile.user_id
    num_posts = login.profile.total_post_count
    num_followers = login.profile.follower_count
    num_followings = login.profile.following_count
    is_private = login.profile.is_private
    bio_len = len(login.profile.biography)
    full_name = len(login.profile.full_name)
    is_business = login.profile.is_business_account
    has_joined_recently = login.profile.is_joined_recently
    url = login.post.share_url
print(url)


