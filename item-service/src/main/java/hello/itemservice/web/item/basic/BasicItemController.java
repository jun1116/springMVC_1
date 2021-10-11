package hello.itemservice.web.item.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor//final이 붙은걸 갖고 생성자를 만들어
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model){
        Item item = new Item(itemName, price, quantity);
        itemRepository.save(item);

        /** 저장된 결과물만 넘겨주면 됨 **/
        model.addAttribute("item", item);
        return "basic/item";
    }

    /** 상품등록처리 ModelAttribute 사용하기 **/
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model){
        itemRepository.save(item);
        /** 저장된 결과물만 넘겨주면 됨 @ModelAttribute 생략시 클래스명(Item)의 앞글자만소문자로 바꿔서 Attribute로 사용**/
//        model.addAttribute("item", item);//자동 추가, 생략 가능
        return "basic/item";
    }
//    @PostMapping("/add")

    public String addItemV3(@ModelAttribute Item item, Model model){//Item -> item 의 이름으로 모델에 담기게돼!
        itemRepository.save(item);
        return "basic/item";
    }
    //    @PostMapping("/add")
    public String addItemV4(Item item){//Item -> item 의 이름으로 모델에 담기게돼!
        itemRepository.save(item);
        return "basic/item";
    }
    /** PRG - Post/Redirect/Get
     * URL에 인코딩 해서 넘겨야 하는 문제가 있어 (item.getId()) **/
//    @PostMapping("/add")
    public String addItemV5(@ModelAttribute("item") Item item){
        itemRepository.save(item);
        return "redirect:/basic/items/"+item.getId();
    }
    /** RedirectAttribute 사용
     *  return 에 담아서  **/
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes){
        itemRepository.save(item);
        //== redirect와 관련된 Attribute를 넣을 수 있어 ==//
        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("status", true);
        /** status 같이 {} 에 못들어간 녀석은 쿼리파라미터로 넘어가게된다 ( ~~{itemId}?status=true ) **/
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    /** For Testing Data **/
    @PostConstruct
    public void init() {

        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }
}
