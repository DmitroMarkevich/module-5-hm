SELECT CONCAT('Project ', p.id) AS id, (SUM(SALARY) * TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE)) AS price
FROM project p
         JOIN project_worker ON p.id = project_worker.project_id
         JOIN worker ON project_worker.worker_id = worker.id
GROUP BY p.id
ORDER BY price DESC;
