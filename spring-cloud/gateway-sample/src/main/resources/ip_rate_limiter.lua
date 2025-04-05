local key = KEYS[1]
local capacity = tonumber(ARGV[1])
local refresh = tonumber(ARGV[2])

-- 判断key是否存在
local current = tonumber(redis.call('incr', key))
if current == 1 then
    redis.call('expire', key, refresh)
    return true
end
return current <= capacity and true or false