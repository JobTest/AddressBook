package com.web;

import com.domain.Contact;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Lazarchuk Alex
 * @version 1.0
 */

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

//    @RequestMapping(value = "/login.jsp", method = RequestMethod.GET)
//    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//                              @RequestParam(value = "logout", required = false) String logout) {
//
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid username and password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//        model.setViewName("login");
//
//        return model;
//
//    }

    @RequestMapping(value = "/list")
    public String listContacts(@RequestParam(value="sort", required=true) String sort, Map<String, Object> map) {
        if(sort.isEmpty()){
            map.put("contactList", contactService.listContact("fio"));
            map.put("sort", "fio");
        } else {
            map.put("contactList", contactService.listContact(sort));
            map.put("sort", sort);
        }
        map.put("pagename", "contacts");
        map.put("positions", contactService.getPositions());
        map.put("ActiveUser", SecurityContextHolder.getContext().getAuthentication().getName());

		return "list";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/list?sort=fio";
	}

    @RequestMapping(value = "/search")
    public String searchContacts(@RequestParam(value="value", required=true) String value, @RequestParam(value="filters", required=true) String filters, @RequestParam(value="filter-on", required=true) String filter_on, Map<String, Object> map) {
        map.put("filter_on", filter_on);
        String[] afilters = filters.split(",");
        if(afilters.length > 0){
            for(String filter : afilters){
                if(filter.equals("fio")){ map.put("fio", "checked"); }
                if(filter.equals("telephone")){ map.put("telephone", "checked"); }
                if(filter.equals("email")){ map.put("email", "checked"); }
                if(filter.equals("address")){ map.put("address", "checked"); }
                if(filter.equals("organization")){ map.put("organization", "checked"); }
                if(filter.equals("position")){ map.put("position", "checked"); }
            }
        }else{
            map.put("fio", "checked");
            map.put("email", "checked");
            map.put("address", "checked");
            map.put("telephone", "checked");
            map.put("organization", "checked");
            map.put("position", "checked");
        }
        if(value.isEmpty()){
            map.put("contactList", contactService.searchContact("fio"));
            map.put("value", "");
        } else {
            if(filter_on.equals("1")){
                map.put("contactList", contactService.filterContact(filters.split(","), value));
            }else{
                map.put("contactList", contactService.searchContact(value));
            }
            map.put("value", value);
        }
        map.put("pagename", "search");
        map.put("positions", contactService.getPositions());
        map.put("ActiveUser", SecurityContextHolder.getContext().getAuthentication().getName());

        return "search";
    }

    @RequestMapping("/new")
    public String newContact(Map<String, Object> map) {
        map.put("contact", new Contact());
        map.put("pagename", "addcontact");
        map.put("positions", contactService.getPositions());
        map.put("ActiveUser", SecurityContextHolder.getContext().getAuthentication().getName());

        return "new";
    }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		contactService.addContact(contact);

		return "redirect:/list?sort=fio";
	}

    @RequestMapping("/view/{contactUsername}")
    public String viewContact(@PathVariable("contactUsername") String contactUsername, Map<String, Object> map) {
        Contact contact = contactService.viewContact(contactUsername);
        map.put("contact", contact);
        map.put("contactUsername", contactUsername);
        map.put("pagename", "view");
        map.put("positions", contactService.getPositions());
        map.put("ActiveUser", SecurityContextHolder.getContext().getAuthentication().getName());

        return "view";
    }

    @RequestMapping("/edit/{contactUsername}")
    public String editContact(@PathVariable("contactUsername") String contactUsername, Map<String, Object> map) {
        Contact contact = contactService.editContact(contactUsername);
        map.put("contact", contact);
        map.put("contactUsername", contactUsername);
        map.put("pagename", "edit");
        map.put("positions", contactService.getPositions());
        map.put("ActiveUser", SecurityContextHolder.getContext().getAuthentication().getName());

        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
        contactService.updateContact(contact);

        return "redirect:/list?sort=fio";
    }

	@RequestMapping("/delete/{contactUsername}")
	public String deleteContact(@PathVariable("contactUsername") String contactUsername) {
		contactService.removeContact(contactUsername);

		return "redirect:/list?sort=fio";
	}
}
