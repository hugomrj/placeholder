

SELECT id, postid, name, email, body
  FROM public.comments
  where postid = v0
  order by id
