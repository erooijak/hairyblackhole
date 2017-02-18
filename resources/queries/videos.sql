-- name: videos
SELECT moz_places.url, moz_bookmarks.title
FROM moz_bookmarks
JOIN moz_places ON moz_bookmarks.fk = moz_places.id
WHERE moz_places.url LIKE '%youtube.com%'
OR moz_places.url LIKE '%youtu.be%'

-- TODO: api key for vimeo, parse vimeo
-- OR (moz_bookmarks.title LIKE '%vimeo%'
--     AND moz_places.url LIKE '%vimeo.com%')
