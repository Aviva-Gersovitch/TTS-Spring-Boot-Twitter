package com.tts.techtalenttwitter.repository;

import com.tts.techtalenttwitter.model.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Long is the type of the primary key which is our ID which is set to long
@Repository
public interface TagRepository extends CrudRepository <Tag, Long> {
    Tag findByPhrase (String phrase);
}
