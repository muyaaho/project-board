alter table comment
add foreign key (post_id) references post(id);