package haw41k.wheels.catalog.dao;

import haw41k.wheels.catalog.WheelsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoWheels {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<WheelModel> modelRowMapper =
            (rs, rowNum) -> new WheelModel(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    "https://images.yst.ru/storage/" + rs.getString(4) + "/md.png");

    private final RowMapper<WheelBrand> brandRowMapper =
            (rs, rowNum) -> new WheelBrand(
                    rs.getInt(1),
                    rs.getString(2));

    public List<WheelModel> getModelsAll() {
        String query =
                "SELECT Models.id, Brands.name, Models.model FROM Brands " +
                        "INNER JOIN Models ON Models.brand_id = Brands.id";

        return jdbcTemplate.query(query, modelRowMapper);
    }

    public List<WheelModel> getModelsByFilter(WheelsForm wheelsForm) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT Models.id, Brands.name, Models.model," +
                        "(SELECT factory_code FROM Wheel_Params WHERE Wheel_Params.model_id = Models.id limit 1) as code" +
                        " FROM Brands ")
                .append("INNER JOIN Models ON Models.brand_id = Brands.id ")
                .append("INNER JOIN Wheel_Params ON Wheel_Params.model_id = Models.id WHERE 1 ");

        if (wheelsForm.getBrandId() != -1)
            sb.append("AND Brands.id = ? ");
        else
            sb.append("AND Brands.id != ? ");

        if (wheelsForm.getSizeDiameter() != -1)
            sb.append("AND Wheel_Params.size_diameter = ? ");
        else
            sb.append("AND Wheel_Params.size_diameter != ? ");

        if (wheelsForm.getSizeWidth() != -1)
            sb.append("AND Wheel_Params.size_width = ? ");
        else
            sb.append("AND Wheel_Params.size_width != ? ");

        if (wheelsForm.getPcdCount() != -1)
            sb.append("AND Wheel_Params.pcd_count = ? ");
        else
            sb.append("AND Wheel_Params.pcd_count != ? ");

        if (wheelsForm.getPcdDiameter() != -1)
            sb.append("AND Wheel_Params.pcd_diameter = ? ");
        else
            sb.append("AND Wheel_Params.pcd_diameter != ? ");

        if (wheelsForm.getEt() != -1)
            sb.append("AND Wheel_Params.et = ? ");
        else
            sb.append("AND Wheel_Params.et != ? ");

        if (wheelsForm.getDia() != -1)
            sb.append("AND Wheel_Params.dia = ? ");
        else
            sb.append("AND Wheel_Params.dia != ? ");


        return jdbcTemplate.query(sb.toString(), ps -> {
                        ps.setInt(1, wheelsForm.getBrandId());
                        ps.setByte(2, wheelsForm.getSizeDiameter());
                        ps.setFloat(3, wheelsForm.getSizeWidth());
                        ps.setByte(4, wheelsForm.getPcdCount());
                        ps.setFloat(5, wheelsForm.getPcdDiameter());
                        ps.setFloat(6, wheelsForm.getEt());
                        ps.setFloat(7, wheelsForm.getDia());
                    }, modelRowMapper);

    }

    public List<WheelBrand> getBrandsAll() {
        String query = "SELECT * FROM Brands";

        return jdbcTemplate.query(query, brandRowMapper);

    }

    public List<Byte> getSizeDiameterAll() {
        String query = "SELECT DISTINCT size_diameter FROM Wheel_Params";

        return jdbcTemplate.query(query, (rs, rowNum) -> rs.getByte(1));
    }

    public List<Float> getSizeWidthAll() {
        String query = "SELECT DISTINCT size_width FROM Wheel_Params";

        return jdbcTemplate.query(query, (rs, rowNum) -> rs.getFloat(1));
    }

    public List<Byte> getPcdCountAll() {
        String query = "SELECT DISTINCT pcd_count FROM Wheel_Params";

        return jdbcTemplate.query(query, (rs, rowNum) -> rs.getByte(1));
    }

    public List<Float> getPcdDiameterAll() {
        String query = "SELECT DISTINCT pcd_diameter FROM Wheel_Params";

        return jdbcTemplate.query(query, (rs, rowNum) -> rs.getFloat(1));
    }

    public List<Float> getEtAll() {
        String query = "SELECT DISTINCT et FROM Wheel_Params";

        return jdbcTemplate.query(query, (rs, rowNum) -> rs.getFloat(1));
    }

    public List<Float> getDiaAll() {
        String query = "SELECT DISTINCT dia FROM Wheel_Params";

        return jdbcTemplate.query(query, (rs, rowNum) -> rs.getFloat(1));
    }

    public WheelModel getModelById(int id) {
        String query =
                "SELECT Models.id, Brands.name, Models.model," +
                        "(SELECT factory_code FROM Wheel_Params WHERE Wheel_Params.model_id = Models.id limit 1) as code" +
                        " FROM Brands " +
                        "INNER JOIN Models ON Models.brand_id = Brands.id " +
                        "WHERE Models.id = ?";

        return jdbcTemplate.queryForObject(query, modelRowMapper, id);
    }

    public List<WheelParams> getParamsByModelId(int modelId) {
        String query =
                "SELECT " +
                        "Wheel_Params.id," +
                        "Wheel_Params.model_id," +
                        "Wheel_Params.size_diameter," +
                        "Wheel_Params.size_width," +
                        "Wheel_Params.pcd_count," +
                        "Wheel_Params.pcd_diameter," +
                        "Wheel_Params.et," +
                        "Wheel_Params.dia," +
                        "Wheel_Params.factory_code," +
                        "Colors.color " +
                        "FROM Wheel_Params " +
                        "INNER JOIN Colors ON Colors.id = Wheel_Params.color_id " +
                        "WHERE Wheel_Params.model_id = ?";

        return jdbcTemplate.query(
                query,
                ps -> ps.setInt(1, modelId),
                (rs, rowNum) -> {
                    WheelParams wheelParams = new WheelParams();

                    wheelParams.setId(rs.getInt(1));
                    wheelParams.setModelId(rs.getInt(2));

                    wheelParams.setSizeDiameter(rs.getByte(3));
                    wheelParams.setSizeWidth(rs.getFloat(4));

                    wheelParams.setPcdCount(rs.getByte(5));
                    wheelParams.setPcdDiameter(rs.getFloat(6));

                    wheelParams.setEt(rs.getFloat(7));
                    wheelParams.setDia(rs.getFloat(8));
                    wheelParams.setFactoryCode(rs.getInt(9));
                    wheelParams.setColor(rs.getString(10));

                    return wheelParams;
                });
    }
}
