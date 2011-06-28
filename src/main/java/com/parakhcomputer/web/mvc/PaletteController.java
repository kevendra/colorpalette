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

package com.parakhcomputer.web.mvc;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.parakhcomputer.util.AppConstant;
import com.parakhcomputer.web.dao.PaletteDao;
import com.parakhcomputer.web.dao.ThemeDao;
import com.parakhcomputer.web.model.Palette;
import com.parakhcomputer.web.model.Theme;


/**
 * Person form controller.
 * 
 * @author David Winterfeldt
 */
@Controller
public class PaletteController {

    private static final String FROM_VIEW_KEY = "redirect:form.html";
    private static final String SEARCH_VIEW_KEY = "redirect:search.html";
    private static final String SEARCH_MODEL_KEY = "palettes";

    @Autowired
    protected PaletteDao paletteDao = null;
    @Autowired
    protected ThemeDao themeDao = null;
    

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_FORMAT);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}    
    /**
     * For every request for this controller, this will 
     * create a palette instance for the form.
     */
    @ModelAttribute
    public Palette newRequest(@RequestParam(required=false) Integer id) {
        return (id != null ? paletteDao.findPaletteById(id) : new Palette());
    }

    /**
     * <p>Person form request.</p>
     * 
     * <p>Expected HTTP GET and request '/palette/form'.</p>
     */
    @RequestMapping(value="/palette/form", method=RequestMethod.GET)
    public void form() {}
    
    /**
     * <p>Saves a palette.</p>
     * 
     * <p>Expected HTTP POST and request '/palette/form'.</p>
     */
    @RequestMapping(value="/palette/form", method=RequestMethod.POST)
    public String form(Palette palette, Model model) {
        if (palette.getCreated() == null) {
            palette.setCreated(new Date());
        }

        Palette result = paletteDao.save(palette);
        

        model.addAttribute("statusMessageKey", "palette.form.msg.success");
        return FROM_VIEW_KEY;
    }

    /**
     * <p>Deletes a palette.</p>
     * 
     * <p>Expected HTTP POST and request '/palette/delete'.</p>
     */
    @RequestMapping(value="/palette/delete", method=RequestMethod.POST)
    public String delete(Palette palette) {
        paletteDao.delete(palette);

        return SEARCH_VIEW_KEY;
    }

    /**
     * <p>Searches for all palettes and returns them in a 
     * <code>Collection</code>.</p>
     * 
     * <p>Expected HTTP GET and request '/palette/search'.</p>
     */
    @RequestMapping(value="/palette/search", method=RequestMethod.GET)
    public @ModelAttribute(SEARCH_MODEL_KEY) Collection<Palette> search() {
        return paletteDao.findPalettes();
    }

    @RequestMapping(value="/palette/advanceSearch", method=RequestMethod.GET)
    public void advanceSearch() {}    
	
    @RequestMapping(value="/palette/advanceSearch", method=RequestMethod.POST)
    public @ModelAttribute(SEARCH_MODEL_KEY) Collection<Palette> advanceSearch(Theme theme, Model model) {
    	    
    	int themeId = 0;
    	
    	if(null!=theme){
    		themeId = theme.getThemeId();
    	}
    	
    	return paletteDao.findPalettesByThemeId(themeId);
    }    
    
	@ModelAttribute("themeList")
	public Map<Integer,String> populateThemeList() {
		Collection<Theme> themes = themeDao.findThemes(); 		
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();    	
    	for(Theme theme : themes){
    		ret.put(theme.getThemeId(), theme.getThemeName());
    	}
   	return ret;
	}    
}
