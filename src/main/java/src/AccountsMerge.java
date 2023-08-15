class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }

        for (List<String> account : accounts) {
            String parent = find(account.get(1), parents);
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i), parents), parent);
            }
        }

        for (List<String> account : accounts) {
            String parent = find(account.get(1), parents);
            if (!unions.containsKey(parent)) {
                unions.put(parent, new TreeSet<>());
            }

            for (int i = 1; i < account.size(); i++) {
                unions.get(parent).add(account.get(i));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(String parent : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(parent));
            emails.add(0, owner.get(parent));
            result.add(emails);
        }

        return result;
    }

    private String find(String s, Map<String, String> parents) {
        return parents.get(s).equals(s) ? s : find(parents.get(s), parents);
    }
}
