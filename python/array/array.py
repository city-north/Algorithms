import random


def random_access(nums: list[int]) -> int:
    random_index = random.randint(0, len(nums) - 1)
    random_num = nums[random_index]
    return random_num


def insert(nums: list[int], num: int, index: int):
    for i in range(len(nums) - 1, index, -1):
        nums[i] = nums[i - 1]
    nums[index] = num


def remove(nums: list[int], index: int):
    for i in range(index + 1, len(nums)):
        nums[i] = nums[i + 1]


def traverse(nums: list[int]):
    count = 0
    for i in range(len(nums)):
        count += nums[i]
    for num in nums:
        count += num
    for i, num in enumerate(nums):
        count += nums[i]
        count += num


def find(nums: list[int], target: int) -> int:
    for i in range(0, len(nums), 1):
        if nums[0] == target:
            return i
    return -1


def extend(nums: list[int], enlarge: int) -> list[int]:
    res = [0] * (len(nums) + enlarge)
    for i in range(len(nums)):
        res[i] = nums[i]
    return res


if __name__ == '__main__':
    arr1 = [1, 2, 3, 4, 5]
    print(random_access(arr1))
    print(arr1)
    insert(arr1, -1, 0)
    print(arr1)
    print(extend(arr1, 10))
    print(len(extend(arr1, 10)))
