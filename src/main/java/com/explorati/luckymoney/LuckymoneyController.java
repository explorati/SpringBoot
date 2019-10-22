package com.explorati.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 18:52 2019/10/22 0022
 * @ Description ：
 */
@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return luckymoneyRepository.findAll();
    }

    /**
     * 创建红包(发红包)
     */
    @PostMapping("luckymoneys")
    public Luckymoney create(@RequestParam("producer")String producer, @RequestParam("money")BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return luckymoneyRepository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id")Integer id) {
        return luckymoneyRepository.findById(id).orElse(null);
    }

    /**
     * 更新红包(领红包)
     */
    @PutMapping("luckymoneys/{id}")
    public Luckymoney updateMoney(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer) {
        Optional<Luckymoney> optional = luckymoneyRepository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return luckymoneyRepository.save(luckymoney);
        }
        return null;
    }
}
