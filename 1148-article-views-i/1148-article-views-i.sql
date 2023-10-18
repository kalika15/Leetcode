# Write your MySQL query statement below
select viewer_id as id from Views where author_id = viewer_id group By(author_id) order By(author_id);