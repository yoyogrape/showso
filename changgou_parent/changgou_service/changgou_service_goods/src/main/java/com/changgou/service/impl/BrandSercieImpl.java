//package com.changgou.service.impl;
//
//import com.changgou.dao.BrandMapper;
//import com.changgou.goods.pojo.Brand;
//import com.changgou.service.BrandService;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.List;
//
//@Service
//public class BrandSercieImpl implements BrandService {
//    @Autowired
//    private BrandMapper brandMapper;
//
//    @Override
//    public List<Brand> findAll() {
//        System.out.println(1 / 0);
//        return brandMapper.selectAll();
//    }
//
//    @Override
//    public Brand findById(Integer id) {
//        return brandMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public void delById(Integer id) {
//        brandMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public void addBrand(Brand brand) {
//        ///方法中带有Selective会忽略空属性
//        brandMapper.insertSelective(brand);
//
//    }
//
//    @Override
//    public void updateBrand(Brand brand) {
//        brandMapper.updateByPrimaryKeySelective(brand);
//    }
//
//    @Override
//    public List<Brand> findBrandListByCondition(Brand brand) {
//        Example example = createExample(brand);
//        return brandMapper.selectByExample(example);
//    }
//
//    @Override
//    public PageInfo<Brand> findPage(Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Brand> brandList = brandMapper.selectAll();
//        return new PageInfo<>(brandList);
//    }
//
//    @Override
//    public PageInfo<Brand> findPageByCondition(Integer pageSize, Integer pageNum, Brand brand) {
//        PageHelper.startPage(pageNum, pageSize);
//        Example example = createExample(brand);
//        List<Brand> brandList = brandMapper.selectByExample(example);
//        return new PageInfo<>(brandList);
//    }
//
//    /**
//     * 条件构建
//     *
//     * @param brand
//     * @return
//     */
//    private Example createExample(Brand brand) {
//        Example example = new Example(Brand.class);
//        Example.Criteria criteria = example.createCriteria();
//
//        if (brand != null) {
//            if (!StringUtils.isEmpty(brand.getName())) {
//                criteria.andLike("name", "%" + brand.getName() + "%");
//            }
//            if (!StringUtils.isEmpty(brand.getLetter())) {
//                criteria.andEqualTo("letter", brand.getLetter());
//            }
//        }
//        return example;
//    }
//}
