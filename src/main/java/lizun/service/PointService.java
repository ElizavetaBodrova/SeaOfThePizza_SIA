package lizun.service;

import lizun.mappers.PointMapper;
import lizun.model.Point;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PointService {


    private PointMapper pointMapper;

    public PointService(PointMapper pointMapper) {
        this.pointMapper = pointMapper;
    }

    public List<Point> getAllPoints(){
        List<Point> points=pointMapper.getAllPoint();
        return pointMapper.getAllPoint();
    }

}
