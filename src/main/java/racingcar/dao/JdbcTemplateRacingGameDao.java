package racingcar.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import racingcar.dto.CarDto;
import racingcar.dto.GameResultDto;

@Repository
public class JdbcTemplateRacingGameDao implements RacingGameDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateRacingGameDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public Number saveGameResult(final GameResultDto gameResultDto, final int trialCount) {
        final String sql = "INSERT INTO GAME_RESULT (winners, trial_count) values (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    new String[]{"id"});
            preparedStatement.setString(1, gameResultDto.getWinners().stream()
                    .map(CarDto::getName)
                    .collect(Collectors.joining(",")));
            preparedStatement.setInt(2, trialCount);
            return preparedStatement;
        }, keyHolder);
        return keyHolder.getKey();
    }

    @Transactional
    public void savePlayerResults(final List<CarDto> racingCars, final Number gameResultKey) {
        String sqlToInsertPlayerResult = "INSERT INTO PLAYER_RESULT (name, position, game_result_id) values (?, ?, ?)";
        for (CarDto carDto : racingCars) {
            jdbcTemplate.update(sqlToInsertPlayerResult, carDto.getName(), carDto.getPosition(), gameResultKey);
        }
    }
}
