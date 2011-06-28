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
import com.parakhcomputer.web.dao.ThemeDao;
import com.parakhcomputer.web.model.Theme;


/**
 * Person form controller.
 * 
 * @author David Winterfeldt
 */
@Controller
public class ThemeController {

    private static final String FROM_VIEW_KEY = "redirect:form.html";
    private static final String SEARCH_VIEW_KEY = "redirect:search.html";
    private static final String SEARCH_MODEL_KEY = "themes";

    @Autowired
    protected ThemeDao themeDao = null;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_FORMAT);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}    
    /**
     * For every request for this controller, this will 
     * create a theme instance for the form.
     */
    @ModelAttribute
    public Theme newRequest(@RequestParam(required=false) Integer id) {
        return (id != null ? themeDao.findThemeById(id) : new Theme());
    }

    /**
     * <p>Person form request.</p>
     * 
     * <p>Expected HTTP GET and request '/theme/form'.</p>
     */
    @RequestMapping(value="/theme/form", method=RequestMethod.GET)
    public void form() {}
    
    /**
     * <p>Saves a theme.</p>
     * 
     * <p>Expected HTTP POST and request '/theme/form'.</p>
     */
    @RequestMapping(value="/theme/form", method=RequestMethod.POST)
    public String form(Theme theme, Model model) {
        if (theme.getCreated() == null) {
            theme.setCreated(new Date());
        }

        Theme result = themeDao.save(theme);
        

        model.addAttribute("statusMessageKey", "theme.form.msg.success");
        return FROM_VIEW_KEY;
    }

    /**
     * <p>Deletes a theme.</p>
     * 
     * <p>Expected HTTP POST and request '/theme/delete'.</p>
     */
    @RequestMapping(value="/theme/delete", method=RequestMethod.POST)
    public String delete(Theme theme) {
        themeDao.delete(theme);

        return SEARCH_VIEW_KEY;
    }

    /**
     * <p>Searches for all themes and returns them in a 
     * <code>Collection</code>.</p>
     * 
     * <p>Expected HTTP GET and request '/theme/search'.</p>
     */
    @RequestMapping(value="/theme/search", method=RequestMethod.GET)
    public @ModelAttribute(SEARCH_MODEL_KEY) Collection<Theme> search() {
        return themeDao.findThemes();
    }

}
