package com.museum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.museum.domain.Account;
import com.museum.service.IAccountService;
import com.museum.util.SystemDateUtils;
import io.swagger.annotations.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.museum.service.ICarRegisterService;
import com.museum.domain.CarRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 新车登记 前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-08-17
 */
@Api(tags = {"办公室驾----新车登记"})
@RestController
@RequestMapping("/car-register")
public class CarRegisterController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICarRegisterService carRegisterService;

    @Resource
    private IAccountService accountService;

    //文件地址
    @Value("${picture}")
    private String picture;


    @ApiOperation(value = "新增新车登记")
    @PostMapping()
    public int add(String cards, String engine, String brand, String colour, String passenger,
                   String model, String displacement, String  buytime, String inspectiontime,
                   String fuelType, String fuel, String createtimes, String name, String address,
                   MultipartFile file, HttpServletRequest req){
                    Account ac=accountService.findAccount(req);
                    CarRegister carRegister = new CarRegister();
                     carRegister.setUid(ac.getId());
                    carRegister.setCards(cards);
                    carRegister.setEngine(engine);
                    carRegister.setBrand(brand);
                    carRegister.setColour(colour);
                    carRegister.setPassenger(passenger);
                    carRegister.setModel(model);
                    carRegister.setDisplacement(displacement);
                    carRegister.setBuytime(buytime);
                    carRegister.setInspectiontime(inspectiontime);
                    carRegister.setFuel(fuel);
                    carRegister.setFuelType(fuelType);
                    carRegister.setCreatetimes(SystemDateUtils.getStrDate());
                    carRegister.setName(name);
                    carRegister.setAddress(address);
                    try{
                        //获取文件后缀
                        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                        // 重构文件名称
                        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
                        String newVidoeName = pikId + "." + fileExt;
                        //保存文件
                        File fileSave = new File(picture, newVidoeName);
                        FileUtils.copyInputStreamToFile(file.getInputStream(), fileSave);
                        carRegister.setAddress(fileSave.getCanonicalPath());
                        carRegister.setName(file.getOriginalFilename());

                    }catch (Exception e){
                        e.printStackTrace();

                    }

                    return carRegisterService.add(carRegister);
    }

    @ApiOperation(value = "删除新车登记")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return carRegisterService.delete(id);
    }

    @ApiOperation(value = "更新新车登记")
    @PutMapping()
    public int update(@RequestBody CarRegister carRegister){

        return carRegisterService.updateData(carRegister);
    }

    @ApiOperation(value = "查询新车登记分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CarRegister> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,String cards){
        QueryWrapper queryWrapper  = new QueryWrapper();

        if(cards!=null&&!"".equals(cards)){
            queryWrapper.like("cards",cards);
        }
        return carRegisterService.page(carRegisterService.findListByPage(page, pageCount),queryWrapper);
    }

    @ApiOperation(value = "id查询新车登记")
    @GetMapping("{id}")
    public CarRegister findById(@PathVariable Long id){
        return carRegisterService.findById(id);
    }

}
