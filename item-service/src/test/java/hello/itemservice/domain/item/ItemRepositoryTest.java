package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){ itemRepository.clearStore();}

    @Test
    public void save() throws Exception{
        //given
        Item itemA = new Item("itemA", 1000, 10);
        //when
        Item savedItem = itemRepository.save(itemA);
        //then
        Item findItem = itemRepository.findById(itemA.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    public void updateItem() throws Exception{
        //given
        Item itemA = new Item("itemA", 1000, 10);
        //when
        Item savedItem = itemRepository.save(itemA);
        Long itemId = savedItem.getId();
        //then
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId, updateParam);
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
    @Test
    public void findAll() throws Exception{
        //given
        Item itemA = new Item("itemA", 1000, 10);
        Item itemB = new Item("itemB", 11000, 110);
        //when
        itemRepository.save(itemA);
        itemRepository.save(itemB);
        List<Item> result = itemRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(1);//2가 나와야함
        assertThat(result).contains(itemA, itemB);
    }


}
