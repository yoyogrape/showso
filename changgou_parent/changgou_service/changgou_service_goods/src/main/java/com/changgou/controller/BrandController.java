//package com.changgou.controller;
//
//import com.changgou.goods.pojo.Brand;
//import com.changgou.service.BrandService;
//import com.github.pagehelper.PageInfo;
//import entity.Result;
//import entity.StatusCode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/brand")
//@CrossOrigin
//public class BrandController {
//    @Autowired
//    private BrandService brandService;
//
//    @GetMapping
//    public Result<List<Brand>> findAll() {
//        List<Brand> brandList = brandService.findAll();
//        return new Result<List<Brand>>(true, StatusCode.OK, "查询品牌集合成功", brandList);
//    }
//
//    @PostMapping("condition")
//    public Result<List<Brand>> findBrandListByCondition(@RequestBody Brand brand) {
//        List<Brand> brandList = brandService.findBrandListByCondition(brand);
//        return new Result<List<Brand>>(true, StatusCode.OK, "条件查询品牌成功", brandList);
//    }
//
//    @GetMapping("/{pageSize}/{pageNum}")
//    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "pageSize") Integer pageSize, @PathVariable(value = "pageNum") Integer pageNum) {
//        PageInfo<Brand> pageBrand = brandService.findPage(pageSize, pageNum);
//        return new Result<PageInfo<Brand>>(true, StatusCode.OK, "分页查询品牌成功", pageBrand);
//    }
//
//    @PostMapping("/{pageSize}/{pageNum}")
//    public Result<PageInfo<Brand>> findPageByCondition(@PathVariable(value = "pageSize") Integer pageSize, @PathVariable(value = "pageNum") Integer pageNum, @RequestBody Brand brand) {
//        PageInfo<Brand> pageBrand = brandService.findPageByCondition(pageSize, pageNum, brand);
//        return new Result<PageInfo<Brand>>(true, StatusCode.OK, "条件分页查询品牌成功", pageBrand);
//    }
//
//    @GetMapping("/{id2}")
//    public Result<Brand> findById(@PathVariable(value = "id2") Integer id) {
//        Brand brand = brandService.findById(id);
//        return new Result<Brand>(true, StatusCode.OK, "查询品牌成功", brand);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public Result delById(@PathVariable Integer id) {
//        brandService.delById(id);
//        return new Result(true, StatusCode.OK, "删除品牌成功");
//    }
//
//    @PostMapping
//    public Result addBrand(@RequestBody Brand brand) {
//        brandService.addBrand(brand);
//        return new Result(true, StatusCode.OK, "增加品牌成功");
//    }
//
//    @PutMapping("/{id}")
//    public Result updateBrand(@RequestBody Brand brand) {
//        brandService.updateBrand(brand);
//        return new Result(true, StatusCode.OK, "修改品牌成功");
//    }
//
//}
