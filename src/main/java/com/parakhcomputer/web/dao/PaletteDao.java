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

import com.parakhcomputer.web.model.Palette;


/**
 * Palette DAO interface.
 * 
 * @author David Winterfeldt
 */
public interface PaletteDao {

    /**
     * Find palette by id.
     */
    public Palette findPaletteById(Integer id);

    /**
     * Find palettes.
     */
    public Collection<Palette> findPalettes();

    /**
     * Find palettes using a start index and max number of results.
     */
    public Collection<Palette> findPalettes(final int startIndex, final int maxResults);

    /**
     * Find palettes by last name.
     */
    public Collection<Palette> findPalettesByLastName(String lastName);

    /**
     * Find palettes by class and school.
     */
    public Collection<Palette> findPalettesBySchoolIdAndClass(int schoolId, int class_);
    
    public List findPalettesByThemeId(int themeId);
    /**
     * Saves palette.
     */
    public Palette save(Palette palette);

    /**
     * Deletes palette.
     */
    public void delete(Palette palette);

    /**
     * Saves address to palette by adding or updating record.
     */
    //public Palette saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//    public Palette deleteAddress(Integer id, Integer addressId);

}

