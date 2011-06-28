/*
 * Copyright 2007-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.parakhcomputer.web.dao;

import java.util.Collection;
import java.util.List;

import com.parakhcomputer.web.model.Theme;


/**
 * Theme DAO interface.
 * 
 * @author David Winterfeldt
 */
public interface ThemeDao {

    /**
     * Find theme by id.
     */
    public Theme findThemeById(Integer id);

    /**
     * Find themes.
     */
    public Collection<Theme> findThemes();

    /**
     * Find themes using a start index and max number of results.
     */
    public Collection<Theme> findThemes(final int startIndex, final int maxResults);

    /**
     * Find themes by last name.
     */
    public Collection<Theme> findThemesByLastName(String lastName);

    /**
     * Find themes by class and school.
     */
    public Collection<Theme> findThemesBySchoolIdAndClass(int schoolId, int class_);
    
    public List findThemesBySchoolId(int schoolId);
    /**
     * Saves theme.
     */
    public Theme save(Theme theme);

    /**
     * Deletes theme.
     */
    public void delete(Theme theme);

    /**
     * Saves address to theme by adding or updating record.
     */
    //public Theme saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//    public Theme deleteAddress(Integer id, Integer addressId);

}

