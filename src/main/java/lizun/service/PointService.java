package lizun.service;

import lizun.mappers.PointMapper;
import lizun.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
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
        for (int i = 0; i <2 ; i++) {
            System.out.println(points.get(i).getAddress());
        }
        return pointMapper.getAllPoint();
    }

}
