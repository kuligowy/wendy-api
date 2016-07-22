/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kuligowy.models.menu.MenuBlockItem;

/**
 *
 * @author mkuligowski
 */
@RepositoryRestResource(exported=false)
public interface JPARepositoryMenuBlockItem extends JpaRepository<MenuBlockItem, Integer> {
}
