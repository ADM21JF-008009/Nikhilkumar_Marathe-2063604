package com.cognizant.HibernateMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.HibernateMapping.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>  {

}
